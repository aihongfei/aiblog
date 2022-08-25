package com.aiblogserver.dao;

import com.aiblogserver.entity.BlogTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (BlogTag)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-09 21:27:25
 */
@Repository
@Mapper
public interface BlogTagDao {

    /**
     * 通过ID查询单条数据
     */
    BlogTag queryById(Integer id);

    /**
     * 查询全部数据
     */
    List<BlogTag> queryAll();

    BlogTag queryBlogIdTagId(Integer blogId,Integer tagId);

    List<BlogTag> queryByTagId(Integer tagId);


    List<BlogTag> queryBlogId(Integer blogId);

    /**
     * 新增数据
     */
    int insert(BlogTag blogTag);

    /**
     * 修改数据
     */
    int update(BlogTag blogTag);

    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);

    /**
     * 通过博客id删除数据
     */
    int deleteByBlogId(Integer id);

}