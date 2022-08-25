package com.aiblogserver.service.impl;

import com.aiblogserver.entity.Comment;
import com.aiblogserver.dao.CommentDao;
import com.aiblogserver.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Comment)表服务实现类
 *
 * @author makejava
 * @since 2021-10-09 21:27:53
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    /**
     * 通过ID查询单条数据
     */
    @Override
    public Comment queryById(Integer id) {
        return commentDao.queryById(id);
    }

    /**
     * 通过博客ID查询数据
     */
    @Override
    public List<Comment> queryByBlogId(Integer blogId) {
        return commentDao.queryByBlogId(blogId);
    }

    /**
     * 新增数据
     */
    @Override
    public boolean insert(Comment comment) {
        return commentDao.insert(comment) > 0;
    }

    /**
     * 修改数据
     */
    @Override
    public boolean update(Comment comment) {
        return commentDao.update(comment) > 0;
    }

    /**
     * 通过主键删除数据
     */
    @Override
    public boolean deleteById(Integer id) {
        return commentDao.deleteById(id) > 0;
    }
}