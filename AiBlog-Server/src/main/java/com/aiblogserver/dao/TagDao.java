package com.aiblogserver.dao;

import com.aiblogserver.entity.Tag;
import com.aiblogserver.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Tag)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-09 21:28:06
 */
@Repository
@Mapper
public interface TagDao {


    /**
     * 通过ID查询单条数据
     */
    Tag queryById(Integer id);

    /**
     * 通过名字模糊查询
     */
    List<Tag> queryByName(String name);

    /**
     * 查询全部数据
     */
    List<Tag> queryAll();

    /**
     * 新增数据
     */
    int insert(Tag tag);

    /**
     * 修改数据
     */
    int update(Tag tag);

    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);

}