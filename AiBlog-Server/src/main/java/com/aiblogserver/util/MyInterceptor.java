package com.aiblogserver.util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Component
public class MyInterceptor implements HandlerInterceptor {

    RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        redisUtil = (RedisUtil) factory.getBean("redisUtil");
        crossDomain(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            //获得注解对象
            NoCheck noCheck = ((HandlerMethod) handler).getMethodAnnotation(NoCheck.class);
            if (noCheck != null) {
                return true;
            } else {
                String token = request.getHeader("token");
                if (token == null || token.equals("")) {
                    response.setStatus(401);
                    return false;
                }
                Object redisToken = redisUtil.get(token);
                if (redisToken != null) {
                    return true;
                }
                response.setStatus(401);
                return false;
            }
        }
        return false;
    }

    public void crossDomain(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "86400");
        response.setHeader("Access-Control-Allow-Headers", "token");
    }

}
