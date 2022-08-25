package com.aiblogserver.service.impl;

import com.aiblogserver.entity.BlogTag;
import com.aiblogserver.dao.BlogTagDao;
import com.aiblogserver.service.BlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BlogTag)表服务实现类
 *
 * @author makejava
 * @since 2021-10-09 21:27:25
 */
@Service("blogTagService")
public class BlogTagServiceImpl implements BlogTagService {
    @Autowired
    private BlogTagDao blogTagDao;

    /**
     * 通过ID查询单条数据
     */
    @Override
    public BlogTag queryById(Integer id) {
        return this.blogTagDao.queryById(id);
    }

    /**
     * 新增数据
     */
    @Override
    public boolean insert(BlogTag blogTag) {
        return blogTagDao.insert(blogTag) > 0;
    }

    /**
     * 修改数据
     */
    @Override
    public boolean update(BlogTag blogTag) {
       return blogTagDao.update(blogTag) > 0;
    }

    /**
     * 通过主键删除数据
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogTagDao.deleteById(id) > 0;
    }
}