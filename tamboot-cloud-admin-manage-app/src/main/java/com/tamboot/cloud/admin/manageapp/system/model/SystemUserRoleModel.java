package com.tamboot.cloud.admin.manageapp.system.model;

import com.tamboot.mybatis.core.BaseModel;

public class SystemUserRoleModel extends BaseModel {
    private static final long serialVersionUID = 3433481455722343601L;

    private Long userId;

    private String roleCode;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
