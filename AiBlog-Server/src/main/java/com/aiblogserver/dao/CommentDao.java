package com.aiblogserver.dao;

import com.aiblogserver.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Comment)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-09 21:27:53
 */
@Repository
@Mapper
public interface CommentDao {

    /**
     * 通过ID查询单条数据
     */
    Comment queryById(Integer id);


    List<Comment> queryByBlogId(Integer blogId);

    /**
     * 新增数据
     */
    int insert(Comment comment);

    /**
     * 修改数据
     */
    int update(Comment comment);

    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);

    /**
     * 通过博客id删除数据
     */
    int deleteByBlogId(Integer blogId);

}