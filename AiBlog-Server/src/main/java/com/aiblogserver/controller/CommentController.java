package com.aiblogserver.controller;

import com.aiblogserver.entity.Comment;
import com.aiblogserver.service.CommentService;
import com.aiblogserver.util.NoCheck;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Comment)表控制层
 *
 * @author makejava
 * @since 2021-10-09 21:27:53
 */
@Api(description = "评论接口")
@RestController
@RequestMapping("comment")
public class CommentController {
    /**
     * 服务对象
     */
    @Autowired
    private CommentService commentService;

    /**
     * 通过主键查询单条数据
     */
    @NoCheck
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("selectOne")
    public JSONObject selectOne(Integer id) {
        JSONObject jsonObject = new JSONObject();
        Comment comment = this.commentService.queryById(id);
        jsonObject.put("comment",comment);
        return jsonObject;
    }

    /**
     * 通过博客id查询数据
     */
    @NoCheck
    @ApiOperation("通过博客id查询数据")
    @GetMapping("selectByBlogId")
    public JSONObject selectByBlogId(Integer blogId) {
        JSONObject jsonObject = new JSONObject();
        List<Comment> comments = this.commentService.queryByBlogId(blogId);
        jsonObject.put("commentList",comments);
        return jsonObject;
    }

    /**
     * 增加数据
     */
    @NoCheck
    @ApiOperation("增加数据")
    @PostMapping("insert")
    public JSONObject add(Comment comment) {
        JSONObject jsonObject = new JSONObject();
        comment.setCreateTime(new Date());
        boolean insert = commentService.insert(comment);
        if (insert){
            jsonObject.put("status",1);
            jsonObject.put("msg","评论成功");
            return jsonObject;
        }
        jsonObject.put("status",0);
        jsonObject.put("msg","评论失败");
        return jsonObject;
    }

    /**
     * 修改数据
     */
    @ApiOperation("修改数据")
    @PostMapping("update")
    public JSONObject update(Comment comment) {
        JSONObject jsonObject = new JSONObject();
        boolean insert = commentService.update(comment);
        if (insert){
            jsonObject.put("status",1);
            jsonObject.put("msg","修改成功");
            return jsonObject;
        }
        jsonObject.put("status",0);
        jsonObject.put("msg","修改失败");
        return jsonObject;
    }

    /**
     * 删除数据
     */
    @ApiOperation("删除数据")
    @GetMapping("delete")
    public JSONObject delete(Integer id) {
        JSONObject jsonObject = new JSONObject();
        boolean insert = commentService.deleteById(id);
        if (insert){
            jsonObject.put("status",1);
            jsonObject.put("msg","删除成功");
            return jsonObject;
        }
        jsonObject.put("status",0);
        jsonObject.put("msg","删除失败");
        return jsonObject;
    }

}