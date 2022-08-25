package com.aiblogserver.service;

import com.aiblogserver.entity.Admin;
import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2021-10-04 11:49:47
 */
public interface AdminService {

    /**
     * 验证登陆
     */
    Admin login(String username,String password);

}