package com.aiblogserver.entity;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2021-10-04 11:49:44
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = -56319194891999516L;
    
    private String username;
    
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}