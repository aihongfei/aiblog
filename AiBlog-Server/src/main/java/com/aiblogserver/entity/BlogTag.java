package com.aiblogserver.entity;

import java.io.Serializable;

/**
 * (BlogTag)实体类
 *
 * @author makejava
 * @since 2021-10-09 21:27:25
 */
public class BlogTag implements Serializable {
    private static final long serialVersionUID = -19010263950193572L;
    
    private Integer id;
    
    private Integer blogId;
    
    private Integer tagId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

}