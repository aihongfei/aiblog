package com.aiblogserver.service.impl;

import com.aiblogserver.entity.Type;
import com.aiblogserver.dao.TypeDao;
import com.aiblogserver.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Type)表服务实现类
 *
 * @author makejava
 * @since 2021-10-09 21:28:22
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;


    /**
     * 通过ID查询单条数据
     */
    @Override
    public Type queryById(Integer id) {
        return typeDao.queryById(id);
    }

    /**
     * 新增数据
     */
    @Override
    public boolean insert(Type type) {
        return typeDao.insert(type) > 0;
    }

    @Override
    public PageInfo<Type> queryByName(int pageNum,int pageSize,String name) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(typeDao.queryByName(name));
    }

    /**
     * 查询全部数据
     */
    @Override
    public PageInfo<Type> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(typeDao.queryAll());
    }

    /**
     * 修改数据
     */
    @Override
    public boolean update(Type type) {
        return typeDao.update(type) > 0;
    }

    /**
     * 通过主键删除数据
     */
    @Override
    public boolean deleteById(Integer id) {
        return typeDao.deleteById(id) > 0;
    }
}