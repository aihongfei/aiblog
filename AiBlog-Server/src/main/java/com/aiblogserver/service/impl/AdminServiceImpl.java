package com.aiblogserver.service.impl;

import com.aiblogserver.entity.Admin;
import com.aiblogserver.dao.AdminDao;
import com.aiblogserver.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2021-10-04 11:49:47
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    /**
     * 验证登陆
     */
    @Override
    public Admin login(String username,String password) {
        return this.adminDao.login(username,password);
    }

}