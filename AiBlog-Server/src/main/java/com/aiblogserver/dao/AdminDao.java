package com.aiblogserver.dao;

import com.aiblogserver.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-04 11:49:46
 */
@Repository
@Mapper
public interface AdminDao {

    /**
     * 验证登陆
     */
    Admin login(String username,String password);

}