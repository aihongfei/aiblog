package com.aiblogserver.dao;

import com.aiblogserver.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Type)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-09 21:28:22
 */
@Repository
@Mapper
public interface TypeDao {

    /**
     * 通过ID查询单条数据
     */
    Type queryById(Integer id);

    /**
     * 通过名字模糊查询
     */
    List<Type> queryByName(String name);

    /**
     * 查询全部数据
     */
    List<Type> queryAll();

    /**
     * 新增数据
     */
    int insert(Type type);

    /**
     * 修改数据
     */
    int update(Type type);

    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);

}