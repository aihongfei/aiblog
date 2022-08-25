package com.aiblogserver.service;

import com.aiblogserver.entity.BlogTag;
import java.util.List;

/**
 * (BlogTag)表服务接口
 *
 * @author makejava
 * @since 2021-10-09 21:27:25
 */
public interface BlogTagService {

    /**
     * 通过ID查询单条数据
     */
    BlogTag queryById(Integer id);

    /**
     * 新增数据
     */
    boolean insert(BlogTag blogTag);

    /**
     * 修改数据
     */
    boolean update(BlogTag blogTag);

    /**
     * 通过主键删除数据
     */
    boolean deleteById(Integer id);

}