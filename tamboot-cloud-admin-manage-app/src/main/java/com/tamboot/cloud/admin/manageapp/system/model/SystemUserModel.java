package com.tamboot.cloud.admin.manageapp.system.model;

import com.tamboot.mybatis.core.BaseModel;

public class SystemUserModel extends BaseModel {
    private static final long serialVersionUID = 8396651372083133960L;

    private String username;

    private String password;

    private Integer status;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
