package com.aiblogserver.dao;

import com.aiblogserver.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Blog)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-09 21:24:18
 */
@Repository
@Mapper
public interface BlogDao {

    /**
     * 通过ID查询单条数据
     */
    Blog queryById(Integer id);

    /**
     * 通过关键字数据
     */
    List<Blog> queryByKeyWords(String keyword);

    /**
     * 查询全部
     */
    List<Blog> queryAll();

    /**
     * 查询全部（发布）
     */
    List<Blog> queryAllPublish();

    /**
     * 随机查询n条数据
     */
    List<Blog> queryRandom(Integer size);

    List<Blog> queryRandomByKey(String keyword,Integer size);

    /**
     * 通过分类ID查询
     */
    List<Blog> querybyTypeId(Integer typeId);

    /**
     * 通过标签ID查询
     */
    List<Blog> querybyTagId(Integer tagId);

    /**
     * 新增数据
     */
    int insert(Blog blog);

    /**
     * 修改数据
     */
    int update(Blog blog);

    /**
     * 增加点击量
     */
    int updateClickNum(Integer id);

    /**
     * 增加点击量
     */
    int updatePublish(Integer published,Integer id);
    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);

}