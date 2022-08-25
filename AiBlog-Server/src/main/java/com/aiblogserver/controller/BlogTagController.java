package com.aiblogserver.controller;

import com.aiblogserver.entity.BlogTag;
import com.aiblogserver.service.BlogTagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (BlogTag)表控制层
 *
 * @author makejava
 * @since 2021-10-09 21:27:25
 */
@RestController
@RequestMapping("blogTag")
public class BlogTagController {
    /**
     * 服务对象
     */
    @Resource
    private BlogTagService blogTagService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BlogTag selectOne(Integer id) {
        return this.blogTagService.queryById(id);
    }

}