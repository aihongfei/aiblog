package com.aiblogserver.controller;

import com.aiblogserver.util.JavaWebToken;
import com.aiblogserver.entity.Admin;
import com.aiblogserver.service.AdminService;
import com.aiblogserver.util.NoCheck;
import com.aiblogserver.util.RedisUtil;
import com.aiblogserver.util.TokenUnavailable;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2021-10-04 11:49:47
 */
@Api(description = "管理员接口")
@RestController
@RequestMapping("admin")
@Slf4j
public class AdminController {
    /**
     * 服务对象
     */
    @Autowired
    private AdminService adminService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 验证登陆
     */
    @NoCheck
    @ApiOperation("验证登陆")
    @PostMapping("/login")
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletResponse response) throws TokenUnavailable {
        log.info("访问 username = {};password = {}", username, password);
        JSONObject jsonObject = new JSONObject();
        Admin admin = this.adminService.login(username, password);
        if (admin == null) {
            log.info("账号或密码错误");
            jsonObject.put("status", "0");
            jsonObject.put("msg", "账号或密码错误");
            return jsonObject;
        }
        Object user = redisUtil.get("user");
        if (user != null) {
            log.info("账号已登陆");
            jsonObject.put("status", "0");
            jsonObject.put("msg", "账号已登陆");
        } else {
            String token = JavaWebToken.createToken(admin.getUsername(), admin.getUsername(), admin.getUsername());
            redisUtil.set(token, JavaWebToken.getAudience(token), 60 * 60 * 24 * 7L);
            redisUtil.set("user", JavaWebToken.getAudience(token), 60 * 60 * 24 * 7L);
            jsonObject.put("status", "1");
            jsonObject.put("msg", "登陆成功");
            log.info("登录成功");
            jsonObject.put("token", token);
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            cookie.setMaxAge(14 * 24 * 60 * 60);//单位秒，设置7天免登录
            cookie.setSecure(true);//使用SSL
            cookie.setHttpOnly(false);
            response.addCookie(cookie);
        }
        return jsonObject;
    }

//    /**
//     * token验证方法
//     */
//    @NoCheck
//    @ApiOperation("验证Token")
//    @PostMapping("/tokenConfirm")
//    public Object tokenConfirm(@RequestParam("token") String token) throws TokenUnavailable {
//        JSONObject jsonObject = new JSONObject();
//        Object redisToken = redisUtil.get(token);
//        if (redisToken != null) {       //根据前端带回来的token验证
//            jsonObject.put("tokenMark", true);                      //验证通过
//        } else {
//            jsonObject.put("tokenMark", false);                      //验证失败
//        }
//        return jsonObject;
//    }

    @ApiOperation("注销")
    @GetMapping("/logout")
    public String logout(HttpServletResponse response, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if (name.contains("token")) {
                cookie.setMaxAge(0);
                cookie.setValue(null);
                cookie.setSecure(true);//使用SSL
                cookie.setHttpOnly(false);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        String token = request.getHeader("token");
        if (token != null) {
            redisUtil.del(token);
            redisUtil.del("user");
        }
        log.info("注销成功");
        return "注销成功";
    }
}