package com.aiblogserver.service;

import com.aiblogserver.entity.Type;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (Type)表服务接口
 *
 * @author makejava
 * @since 2021-10-09 21:28:22
 */
public interface TypeService {

    /**
     * 通过ID查询单条数据
     */
    Type queryById(Integer id);

    /**
     * 新增数据
     */
    boolean insert(Type type);

    /**
     * 根据名字模糊查询
     */
    PageInfo<Type> queryByName(int PageNum,int PageSize,String name);

    /**
     * 查询全部数据
     */
    PageInfo<Type> queryAll(int pageNum,int pageSize);

    /**
     * 修改数据
     */
    boolean update(Type type);

    /**
     * 通过主键删除数据
     */
    boolean deleteById(Integer id);

}