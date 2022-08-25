package com.aiblogserver.service;

import com.aiblogserver.entity.Comment;
import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @author makejava
 * @since 2021-10-09 21:27:53
 */
public interface CommentService {

    /**
     * 通过ID查询单条数据
     */
    Comment queryById(Integer id);

    /**
     * 通过博客ID查询数据
     */
    List<Comment> queryByBlogId(Integer blogId);

    /**
     * 新增数据
     */
    boolean insert(Comment comment);

    /**
     * 修改数据
     */
    boolean update(Comment comment);

    /**
     * 通过主键删除数据
     */
    boolean deleteById(Integer id);

}