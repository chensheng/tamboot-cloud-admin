package com.tamboot.cloud.admin.manageapp.system.model;

import com.tamboot.mybatis.core.BaseModel;

public class SystemPermissionModel extends BaseModel {
    private static final long serialVersionUID = 2736248942647912401L;

    private String url;

    private String roles;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
