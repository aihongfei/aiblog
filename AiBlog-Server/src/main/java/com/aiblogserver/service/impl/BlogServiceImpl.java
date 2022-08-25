package com.aiblogserver.service.impl;

import com.aiblogserver.dao.BlogTagDao;
import com.aiblogserver.dao.CommentDao;
import com.aiblogserver.entity.Blog;
import com.aiblogserver.dao.BlogDao;
import com.aiblogserver.entity.BlogTag;
import com.aiblogserver.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (Blog)表服务实现类
 *
 * @author makejava
 * @since 2021-10-09 21:24:20
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;

    @Autowired
    private BlogTagDao blogTagDao;

    @Autowired
    private CommentDao commentDao;

    /**
     * 通过ID查询单条数据
     */
    @Override
    public Blog queryById(Integer id) {
        return this.blogDao.queryById(id);
    }

    /**
     * 查询多条数据
     */
    @Override
    public PageInfo<Blog> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "id desc");
        return new PageInfo<>(blogDao.queryAll());
    }

    /**
     * 查询多条数据(发布)
     */
    @Override
    public PageInfo<Blog> queryAllPublish(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "id desc");
        return new PageInfo<>(blogDao.queryAllPublish());
    }

    /**
     * 随机查询n条数据
     */
    @Override
    public List<Blog> queryRandom(int size) {
        return blogDao.queryRandom(size);
    }

    @Override
    public List<Blog> queryRandomByKey(String keyword,int size) {
        return blogDao.queryRandomByKey(keyword,size);
    }

    /**
     * 根据关键字查询数据
     */
    @Override
    public PageInfo<Blog> queryByKeyword(String keyword, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "id desc");
        return new PageInfo<>(blogDao.queryByKeyWords(keyword));
    }

    /**
     * 根据分类ID查询数据
     */
    @Override
    public PageInfo<Blog> queryByTypeId(Integer typeId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "id desc");
        return new PageInfo<>(blogDao.querybyTypeId(typeId));
    }

    /**
     * 根据标签id查询数据
     */
    public PageInfo<Blog> queryByTagId(Integer tagId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "id desc");
        return new PageInfo<>(blogDao.querybyTagId(tagId));
    }

    /**
     * 新增数据
     */
    @Override
    @Transactional
    public boolean insert(Blog blog, List<Integer> tagIds) {
        if (!tagIds.isEmpty()) {
            try {
                this.blogDao.insert(blog);
                tagIds.forEach(item -> {
                    BlogTag blogTag = new BlogTag();
                    blogTag.setBlogId(blog.getId());
                    blogTag.setTagId(item);
                    this.blogTagDao.insert(blogTag);
                });
                return true;
            } catch (RuntimeException e) {
                throw new RuntimeException("该tag不存在");
            }
        }
        return this.blogDao.insert(blog) > 0;
    }

    /**
     * 增加点击量
     */
    @Override
    public boolean updateClickNum(Integer id) {
        return blogDao.updateClickNum(id) > 0;
    }

    /**
     * 修改发布状态
     */
    @Override
    public boolean updatePublished(Integer published,Integer id) {
        return blogDao.updatePublish(published,id) > 0;
    }

    /**
     * 修改数据
     */
    @Override
    @Transactional
    public boolean update(Blog blog, List<Integer> tagIds) {
        if (!tagIds.isEmpty()) {
            try {
                this.blogDao.update(blog);
                blogTagDao.deleteByBlogId(blog.getId());
                tagIds.forEach(item -> {
                    BlogTag blogTag = new BlogTag();
                    blogTag.setTagId(item);
                    blogTag.setBlogId(blog.getId());
                    blogTagDao.insert(blogTag);
                });
                return true;
            } catch (RuntimeException e) {
                throw new RuntimeException("该tag不存在");
            }
        }
        return this.blogDao.update(blog) > 0;
    }

    /**
     * 通过主键删除数据
     */
    @Override
    @Transactional
    public boolean deleteById(Integer id) {
        try {
            this.blogTagDao.deleteByBlogId(id);
            this.commentDao.deleteByBlogId(id);
            return this.blogDao.deleteById(id) > 0;
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }
    }

}