package com.aiblogserver.controller;

import com.aiblogserver.entity.Tag;
import com.aiblogserver.entity.Type;
import com.aiblogserver.service.TagService;
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
import java.util.List;

/**
 * (Tag)表控制层
 *
 * @author makejava
 * @since 2021-10-09 21:28:06
 */
@Api(description = "标签接口")
@RestController
@RequestMapping("tag")
@Slf4j
public class TagController {
    /**
     * 服务对象
     */
    @Autowired
    private TagService tagService;

    /**
     * 通过主键查询单条数据
     */
    @NoCheck
    @ApiOperation("根据id查询")
    @GetMapping("selectOne")
    public JSONObject selectOne(Integer id) {
        log.info("查询标签 id: {}", id);
        JSONObject jsonObject = new JSONObject();
        Tag tag = this.tagService.queryById(id);
        jsonObject.put("tag", tag);
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
        log.info("查询全部标签 pageNum = {};pageSize = {}", pageNum, pageSize);
        JSONObject jsonObject = new JSONObject();
        PageInfo<Tag> tagPageInfo = this.tagService.queryAll(pageNum, pageSize);
        jsonObject.put("tagList", tagPageInfo.getList());
        jsonObject.put("count", tagPageInfo.getTotal());
        jsonObject.put("pages", tagPageInfo.getPages());
        jsonObject.put("pageNum", tagPageInfo.getPageNum());
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
        log.info("查询标签（关键字） keyword = {};pageNum = {};pageSize = {}", keyword, pageNum, pageSize);
        JSONObject jsonObject = new JSONObject();
        PageInfo<Tag> tagPageInfo = this.tagService.queryByName(pageNum, pageSize, "%" + keyword + "%");
        jsonObject.put("tagList", tagPageInfo.getList());
        jsonObject.put("pages", tagPageInfo.getPages());
        jsonObject.put("pageNum", tagPageInfo.getPageNum());
        return jsonObject;
    }

    /**
     * 根据博客id查询数据
     */
    @NoCheck
    @ApiOperation("根据博客id查询数据")
    @GetMapping("selectByBlogId")
    public JSONObject search(@RequestParam("blogId") Integer blogId) {
        log.info("根据博客ID查询标签 blogId: {}", blogId);
        JSONObject jsonObject = new JSONObject();
        List<Tag> tagList = tagService.queryByBlogId(blogId);
        jsonObject.put("tagList", tagList);
        return jsonObject;
    }

    /**
     * 增加数据
     */
    @PostMapping("insert")
    @ApiOperation("增加数据")
    public JSONObject insert(Tag tag) {
        log.info("增加标签 name: {}", tag.getName());
        JSONObject jsonObject = new JSONObject();
        boolean insert = this.tagService.insert(tag);
        if (insert) {
            jsonObject.put("status", "1");
            jsonObject.put("msg", "增加标签成功");
            log.info("增加标签成功");
            return jsonObject;
        }
        jsonObject.put("status", "0");
        jsonObject.put("msg", "增加标签失败");
        log.info("增加标签失败");
        return jsonObject;
    }

    /**
     * 修改数据
     */
    @PostMapping("update")
    @ApiOperation("修改数据")
    public JSONObject update(Tag tag) {
        log.info("修改标签 tagId: {};name: {}", tag.getId(), tag.getName());
        JSONObject jsonObject = new JSONObject();
        boolean update = this.tagService.update(tag);
        if (update) {
            jsonObject.put("status", "1");
            jsonObject.put("msg", "修改标签成功");
            log.info("修改标签成功");
            return jsonObject;
        }
        jsonObject.put("status", "0");
        jsonObject.put("msg", "修改标签失败");
        log.info("修改标签失败");
        return jsonObject;
    }

    /**
     * 删除数据
     */
    @ApiOperation("删除数据")
    @GetMapping("delete")
    public JSONObject delete(Integer id) {
        log.info("删除标签 id: {}", id);
        JSONObject jsonObject = new JSONObject();
        boolean b = tagService.deleteById(id);
        if (b) {
            jsonObject.put("status", "1");
            jsonObject.put("msg", "删除标签成功");
            log.info("删除标签成功");
            return jsonObject;
        }
        jsonObject.put("status", "0");
        jsonObject.put("msg", "删除标签失败");
        log.info("删除标签失败");
        return jsonObject;
    }

}