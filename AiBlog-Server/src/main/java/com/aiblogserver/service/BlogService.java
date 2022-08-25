package com.aiblogserver.service;

import com.aiblogserver.entity.Blog;
import com.aiblogserver.entity.BlogTag;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (Blog)表服务接口
 *
 * @author makejava
 * @since 2021-10-09 21:24:19
 */
public interface BlogService {

    /**
     * 通过ID查询单条数据
     */
    Blog queryById(Integer id);

    /**
     * 查询全部数据
     */
    PageInfo<Blog> queryAll(int pageNum,int pageSize);

    /**
     * 查询全部数据
     */
    PageInfo<Blog> queryAllPublish(int pageNum,int pageSize);

    /**
     * 随机查询n条数据
     */
    List<Blog> queryRandom(int size);

    List<Blog> queryRandomByKey(String keyword,int size);

    /**
     * 根据关键字查询数据
     */
    PageInfo<Blog> queryByKeyword(String keyword,int pageNum,int pageSize);

    /**
     * 根据分类id查询数据
     */
    PageInfo<Blog> queryByTypeId(Integer typeId,int pageNum,int pageSize);

    /**
     * 根据标签id查询数据
     */
    PageInfo<Blog> queryByTagId(Integer tagId, int pageNum, int pageSize);

    /**
     * 新增数据
     */
    boolean insert(Blog blog,List<Integer> tagIds);

    /**
     * 增加点击量
     */
    boolean updateClickNum(Integer id);

    /**
     * 修改发布状态
     */
    boolean updatePublished(Integer published,Integer id);

    /**
     * 修改数据
     */
    boolean update(Blog blog, List<Integer> tagIds);

    /**
     * 通过主键删除数据
     */
    boolean deleteById(Integer id);

}