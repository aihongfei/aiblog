package com.aiblogserver.service;

import com.aiblogserver.entity.Tag;
import com.aiblogserver.entity.Type;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (Tag)表服务接口
 *
 * @author makejava
 * @since 2021-10-09 21:28:06
 */
public interface TagService {

    /**
     * 通过ID查询单条数据
     */
    Tag queryById(Integer id);

    /**
     * 新增数据
     */
    boolean insert(Tag tag);

    /**
     * 根据名字模糊查询
     */
    PageInfo<Tag> queryByName(int PageNum, int PageSize, String name);

    /**
     * 查询全部数据
     */
    PageInfo<Tag> queryAll(int pageNum,int pageSize);

    /**
     * 根据博客id查询数据
     */
    List<Tag> queryByBlogId(Integer blogId);

    /**
     * 修改数据
     */
    boolean update(Tag tag);

    /**
     * 通过主键删除数据
     */
    boolean deleteById(Integer id);

}