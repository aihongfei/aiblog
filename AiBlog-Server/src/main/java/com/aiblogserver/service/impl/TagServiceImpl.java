package com.aiblogserver.service.impl;

import com.aiblogserver.dao.BlogTagDao;
import com.aiblogserver.dao.TypeDao;
import com.aiblogserver.entity.BlogTag;
import com.aiblogserver.entity.Tag;
import com.aiblogserver.dao.TagDao;
import com.aiblogserver.entity.Type;
import com.aiblogserver.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Tag)表服务实现类
 *
 * @author makejava
 * @since 2021-10-09 21:28:06
 */
@Service("tagService")
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;

    @Autowired
    private BlogTagDao blogTagDao;


    /**
     * 通过ID查询单条数据
     */
    @Override
    public Tag queryById(Integer id) {
        return tagDao.queryById(id);
    }

    /**
     * 新增数据
     */
    @Override
    public boolean insert(Tag tag) {
        return tagDao.insert(tag) > 0;
    }

    @Override
    public PageInfo<Tag> queryByName(int pageNum, int pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(tagDao.queryByName(name));
    }

    /**
     * 查询全部数据
     */
    @Override
    public PageInfo<Tag> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(tagDao.queryAll());
    }

    /**
     * 根据博客id查询数据
     */
    @Override
    public List<Tag> queryByBlogId(Integer blogId) {
        List<BlogTag> blogTags = blogTagDao.queryBlogId(blogId);
        List<Tag> tagList = new ArrayList<>();
        blogTags.forEach(item -> {
            tagList.add(tagDao.queryById(item.getTagId()));
        });
        return tagList;
    }

    /**
     * 修改数据
     */
    @Override
    public boolean update(Tag tag) {
        return tagDao.update(tag) > 0;
    }

    /**
     * 通过主键删除数据
     */
    @Override
    public boolean deleteById(Integer id) {
        return tagDao.deleteById(id) > 0;
    }
}