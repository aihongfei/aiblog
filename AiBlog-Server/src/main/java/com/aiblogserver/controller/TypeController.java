package com.aiblogserver.controller;

import com.aiblogserver.entity.Blog;
import com.aiblogserver.entity.Type;
import com.aiblogserver.service.TypeService;
import com.aiblogserver.util.NoCheck;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (Type)表控制层
 *
 * @author makejava
 * @since 2021-10-09 21:28:22
 */
@Api(description = "分类接口")
@RestController
@RequestMapping("type")
@Slf4j
public class TypeController {
    /**
     * 服务对象
     */
    @Autowired
    private TypeService typeService;

    /**
     * 通过主键查询单条数据
     */
    @NoCheck
    @ApiOperation("根据id查询")
    @GetMapping("selectOne")
    public JSONObject selectOne(Integer id) {
        log.info("查询分类 id: {}", id);
        JSONObject jsonObject = new JSONObject();
        Type type = this.typeService.queryById(id);
        jsonObject.put("type", type);
        return jsonObject;
    }

    /**
     * 查询全部数据
     */
    @NoCheck
    @ApiOperation("查询全部数据")
    @GetMapping("selectAll")
    public JSONObject queryall(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "9") int pageSize) {
        log.info("查询全部分类 pageNum = {};pageSize = {}", pageNum, pageSize);
        JSONObject jsonObject = new JSONObject();
        PageInfo<Type> typePageInfo = this.typeService.queryAll(pageNum, pageSize);
        jsonObject.put("typeList", typePageInfo.getList());
        jsonObject.put("count", typePageInfo.getTotal());
        jsonObject.put("pages", typePageInfo.getPages());
        jsonObject.put("pageNum", typePageInfo.getPageNum());
        return jsonObject;
    }

    /**
     * 根据名字模糊查询数据
     */
    @NoCheck
    @ApiOperation("根据名字模糊查询数据")
    @GetMapping("selectByName")
    public JSONObject search(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "9") int pageSize,
                             @RequestParam("keywords") String keyword) {
        log.info("查询分类（关键字） keyword = {};pageNum = {};pageSize = {}", keyword, pageNum, pageSize);
        JSONObject jsonObject = new JSONObject();
        PageInfo<Type> typePageInfo = this.typeService.queryByName(pageNum, pageSize, "%" + keyword + "%");
        jsonObject.put("typeList", typePageInfo.getList());
        jsonObject.put("pages", typePageInfo.getPages());
        jsonObject.put("pageNum", typePageInfo.getPageNum());
        return jsonObject;
    }

    /**
     * 增加数据
     */
    @PostMapping("insert")
    @ApiOperation("增加数据")
    public JSONObject insert(Type type) {
        log.info("增加分类 name: {}", type.getName());
        JSONObject jsonObject = new JSONObject();
        boolean insert = this.typeService.insert(type);
        if (insert) {
            jsonObject.put("status", "1");
            jsonObject.put("msg", "增加分类成功");
            log.info("增加分类成功");
            return jsonObject;
        }
        jsonObject.put("status", "0");
        jsonObject.put("msg", "增加分类失败");
        log.info("增加分类失败");
        return jsonObject;
    }

    /**
     * 修改数据
     */
    @PostMapping("update")
    @ApiOperation("修改数据")
    public JSONObject update(Type type) {
        log.info("增加分类 id: {};name: {}", type.getId(), type.getName());
        JSONObject jsonObject = new JSONObject();
        boolean update = this.typeService.update(type);
        if (update) {
            jsonObject.put("status", "1");
            jsonObject.put("msg", "修改分类成功");
            log.info("修改分类成功");
            return jsonObject;
        }
        jsonObject.put("status", "0");
        jsonObject.put("msg", "修改分类失败");
        log.info("修改分类失败");
        return jsonObject;
    }

    /**
     * 删除数据
     */
    @ApiOperation("删除数据")
    @GetMapping("delete")
    public JSONObject delete(Integer id) {
        log.info("修改分类 id: {}", id);
        JSONObject jsonObject = new JSONObject();
        boolean b = typeService.deleteById(id);
        if (b) {
            jsonObject.put("status", "1");
            jsonObject.put("msg", "删除分类成功");
            log.info("删除分类成功");
            return jsonObject;
        }
        jsonObject.put("status", "0");
        jsonObject.put("msg", "删除分类失败");
        log.info("删除分类失败");
        return jsonObject;
    }

}