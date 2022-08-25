package com.aiblogserver.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (Blog)实体类
 *
 * @author makejava
 * @since 2021-10-09 21:24:16
 */
public class Blog implements Serializable {
    private static final long serialVersionUID = 155148561148715154L;
    
    private Integer id;
    /**
    * 标题
    */
    private String title;
    /**
    * 内容
    */
    private String content;
    /**
    * 创建日期
    */
    private Date createTime;
    /**
    * 更新日期
    */
    private Date updateTime;
    /**
    * 1发布 0未发布
    */
    private Integer published;
    /**
    * 简单描述
    */
    private String description;
    /**
    * 点击数
    */
    private Integer clickNum;
    /**
     * 分类id
     */
    private Integer typeId;

    private String typeName;


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Object getPublished() {
        return published;
    }

    public void setPublished(Integer published) {
        this.published = published;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

}