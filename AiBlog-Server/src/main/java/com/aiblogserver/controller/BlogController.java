package com.aiblogserver.controller;

import com.aiblogserver.entity.Blog;
import com.aiblogserver.service.BlogService;
import com.aiblogserver.util.NoCheck;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * (Blog)表控制层
 *
 * @author makejava
 * @since 2021-10-09 21:24:20
 */

@Api(description = "博客接口")
@RestController
@RequestMapping("blog")
@Slf4j
public class BlogController {
    /**
     * 服务对象
     */
    @Autowired
    private BlogService blogService;


    /**
     * 通过主键查询单条数据
     */
    @NoCheck
    @GetMapping("selectOne")
    @ApiOperation("根据id查询数据")
    public JSONObject selectOne(Integer id) {
        log.info("根据id查询数据 id = {}", id);
        JSONObject jsonObject = new JSONObject();
        Blog blog = this.blogService.queryById(id);
        jsonObject.put("blog", blog);
        return jsonObject;
    }

    /**
     * 增加点击量
     */
    @NoCheck
    @PostMapping("addClickNum")
    @ApiOperation("增加点击量")
    public JSONObject addClickNum(@RequestParam("blogId") Integer blogId) {
        log.info("id = " + blogId + "增加点击量");
        JSONObject jsonObject = new JSONObject();
        boolean b = blogService.updateClickNum(blogId);
        if (b) {
            jsonObject.put("status", "1");
            jsonObject.put("msg", "增加成功");
            log.info("增加点击量成功");
            return jsonObject;
        }
        jsonObject.put("status", "0");
        jsonObject.put("msg", "增加失败");
        log.info("增加点击量失败");
        return jsonObject;
    }

    /**
     * 修改发布状态
     */
    @PostMapping("updatePublish")
    @ApiOperation("修改发布状态")
    public JSONObject updatePublished(@RequestParam("published") Integer published,
                                      @RequestParam("blogId") Integer blogId) {
        log.info("博客 id = {} 修改发布状态为 {}", blogId, (published == 0 ? "不发布" : "发布"));
        JSONObject jsonObject = new JSONObject();
        boolean b = blogService.updatePublished(published, blogId);
        if (b) {
            jsonObject.put("status", "1");
            jsonObject.put("msg", "修改发布成功");
            log.info("修改成功");
            return jsonObject;
        }
        jsonObject.put("status", "0");
        jsonObject.put("msg", "修改发布失败");
        return jsonObject;
    }

    /**
     * 查询全部数据
     */
    @NoCheck
    @GetMapping("selectAll")
    @ApiOperation("查询全部数据")
    public JSONObject selectAll(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "9") int pageSize) {
        log.info("查询全部数据;pageNum = {};pageSize = {}", pageNum, pageSize);
        JSONObject jsonObject = new JSONObject();
        PageInfo<Blog> blogPageInfo = this.blogService.queryAll(pageNum, pageSize);
        jsonObject.put("blogList", blogPageInfo.getList());
        jsonObject.put("pages", blogPageInfo.getPages());
        jsonObject.put("total", blogPageInfo.getTotal());
        jsonObject.put("pageNum", blogPageInfo.getPageNum());
        return jsonObject;
    }

    /**
     * 查询全部数据(发布)
     */
    @NoCheck
    @GetMapping("selectAllPublish")
    @ApiOperation("查询全部数据(发布)")
    public JSONObject selectAllPublish(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "9") int pageSize) {
        log.info("查询全部数据（已发布）;pageNum = {}};pageSize = {}", pageNum, pageSize);
        JSONObject jsonObject = new JSONObject();
        PageInfo<Blog> blogPageInfo = this.blogService.queryAllPublish(pageNum, pageSize);
        jsonObject.put("blogList", blogPageInfo.getList());
        jsonObject.put("pages", blogPageInfo.getPages());
        jsonObject.put("total", blogPageInfo.getTotal());
        jsonObject.put("pageNum", blogPageInfo.getPageNum());
        return jsonObject;
    }

    /**
     * 随机查询n条数据
     */
    @NoCheck
    @GetMapping("selectRandom")
    @ApiOperation("随机查询n条数据")
    public JSONObject selectRandom(@RequestParam(value = "size", defaultValue = "5") int size) {
        log.info("随机查询 {} 条数据", size);
        JSONObject jsonObject = new JSONObject();
        List<Blog> blogs = blogService.queryRandom(size);
        jsonObject.put("blogListRandom", blogs);
        return jsonObject;
    }

    /**
     * 随机查询n条数据(关键字)
     */
    @NoCheck
    @GetMapping("selectRandomByKey")
    @ApiOperation("随机查询n条数据(关键字)")
    public JSONObject queryRandomByKey(@RequestParam("keyword") String keyword,
                                       @RequestParam(value = "size", defaultValue = "5") int size) {
        log.info("随机查询 {} 条数据;关键字为：{}", size, keyword);
        JSONObject jsonObject = new JSONObject();
        List<Blog> blogs = blogService.queryRandomByKey("%" + keyword + "%", size);
        jsonObject.put("blogListRandomByKey", blogs);
        return jsonObject;
    }

    /**
     * 根据关键字查询数据
     */
    @NoCheck
    @GetMapping("search")
    @ApiOperation("根据关键字查询数据")
    public JSONObject selectByKeyword(@RequestParam("keyword") String keyword,
                                      @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "9") int pageSize) {
        log.info("查询数据（关键字）;keyword = {};pageNum = {};pageSize = {}", keyword, pageNum, pageSize);
        JSONObject jsonObject = new JSONObject();
        PageInfo<Blog> blogPageInfo = this.blogService.queryByKeyword("%" + keyword + "%", pageNum, pageSize);
        jsonObject.put("blogList", blogPageInfo.getList());
        jsonObject.put("pages", blogPageInfo.getPages());
        jsonObject.put("total", blogPageInfo.getTotal());
        jsonObject.put("pageNum", blogPageInfo.getPageNum());
        return jsonObject;
    }

    /**
     * 根据分类ID查询数据
     */
    @NoCheck
    @GetMapping("selectByTypeId")
    @ApiOperation("根据分类id查询数据")
    public JSONObject selectByTypeId(@RequestParam("typeId") Integer typeId,
                                     @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "9") int pageSize) {
        log.info("查询数据（分类）;typeId = {};pageNum = {};pageSize = {}", typeId, pageNum, pageSize);
        JSONObject jsonObject = new JSONObject();
        PageInfo<Blog> blogPageInfo = this.blogService.queryByTypeId(typeId, pageNum, pageSize);
        jsonObject.put("blogList", blogPageInfo.getList());
        jsonObject.put("pages", blogPageInfo.getPages());
        jsonObject.put("pageNum", blogPageInfo.getPageNum());
        return jsonObject;
    }

    /**
     * 根据分类ID查询数据
     */
    @NoCheck
    @GetMapping("selectByTagId")
    @ApiOperation("根据标签id查询数据")
    public JSONObject selectByTagId(@RequestParam("tagId") Integer tagId,
                                    @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "9") int pageSize) {
        log.info("查询数据（标签）;tagId = {};pageNum = {};pageSize = {}", tagId, pageNum, pageSize);
        JSONObject jsonObject = new JSONObject();
        PageInfo<Blog> blogPageInfo = this.blogService.queryByTagId(tagId, pageNum, pageSize);
        jsonObject.put("blogList", blogPageInfo.getList());
        jsonObject.put("pages", blogPageInfo.getPages());
        jsonObject.put("pageNum", blogPageInfo.getPageNum());
        return jsonObject;
    }

    /**
     * 增加数据
     */
    @PostMapping("insert")
    @ApiOperation("增加数据")
    public JSONObject insert(Blog blog, @RequestParam("tagIds") List<Integer> tagIds) {
        log.info("增加博客 title: {}", blog.getTitle());
        JSONObject jsonObject = new JSONObject();
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setClickNum(0);
        try {
            this.blogService.insert(blog, tagIds);
            jsonObject.put("status", "1");
            jsonObject.put("msg", "增加博客成功");
            log.info("增加博客成功");
        } catch (Exception e) {
            jsonObject.put("status", "0");
            jsonObject.put("msg", "增加博客失败");
            log.error("增加博客失败");
        }
        return jsonObject;
    }

    /**
     * 修改数据
     */
    @PostMapping("update")
    @ApiOperation("修改数据")
    public JSONObject update(Blog blog, @RequestParam("tagIds") List<Integer> tagIds) {
        log.info("修改博客 id: {};title: {}", blog.getId(), blog.getTitle());
        JSONObject jsonObject = new JSONObject();
        blog.setUpdateTime(new Date());
        try {
            this.blogService.update(blog, tagIds);
            jsonObject.put("status", "1");
            jsonObject.put("msg", "修改博客成功");
            log.info("修改博客成功");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("status", "0");
            jsonObject.put("msg", "修改博客失败");
            log.error("修改博客失败");
        }
        return jsonObject;
    }

    /**
     * 删除数据
     */
    @ApiOperation("删除数据")
    @GetMapping("delete")
    public JSONObject delete(@RequestParam("id") Integer id) {
        log.info("删除boke id: {}", id);
        JSONObject jsonObject = new JSONObject();
        try {
            boolean b = blogService.deleteById(id);
            if (b) {
                jsonObject.put("status", "1");
                jsonObject.put("msg", "删除博客成功");
                log.info("删除博客成功");
            } else {
                jsonObject.put("status", "0");
                jsonObject.put("msg", "删除博客失败");
                log.info("删除博客失败");
            }
        } catch (Exception e) {
            jsonObject.put("status", "0");
            jsonObject.put("msg", "删除博客失败");
            log.error("删除博客失败");
        }
        return jsonObject;
    }


    @ApiOperation("添加图片（文件）")
    @PostMapping("/img")
    public Object addImg(@RequestParam("file") MultipartFile avatorFile) {
        JSONObject jsonObject = new JSONObject();
        if (avatorFile.isEmpty()) {
            jsonObject.put("status", "图片上传失败");
            return jsonObject;
        }
        String fileName = System.currentTimeMillis() + avatorFile.getOriginalFilename();
        log.info("上传图片 name: {}", fileName);
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        try {
            avatorFile.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            jsonObject.put("status", "0");
            jsonObject.put("msg", "图片上传失败");
            log.error("图片上传失败");
        }
        jsonObject.put("url", "/img/" + fileName);
        jsonObject.put("status", "1");
        jsonObject.put("msg", "图片上传成功");
        log.info("图片上传成功");
        return jsonObject;
    }


    @ApiOperation("删除图片（文件）")
    @GetMapping("/deleteImg")
    public Object deleteImg(@RequestParam("path") String path) {
        JSONObject jsonObject = new JSONObject();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
                + System.getProperty("file.separator") + path;
        jsonObject.put("filepath", filePath);
        log.info("删除图片 路径: {}", filePath);
        File delFile = new File(filePath);
        if (delFile.isFile() && delFile.exists()) {
            if (delFile.delete()) {
                jsonObject.put("status", "1");
                jsonObject.put("msg", "图片删除成功");
                log.info("图片删除成功");
            }
        } else {
            jsonObject.put("status", "0");
            jsonObject.put("msg", "图片删除失败");
            log.info("图片删除失败");
        }
        return jsonObject;
    }

}