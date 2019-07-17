package com.tamboot.cloud.admin.manageapp.system.model;

import com.tamboot.mybatis.core.BaseModel;

public class SystemRoleMenuModel extends BaseModel {
    private static final long serialVersionUID = 2772363078857543526L;

    private String roleCode;

    private Long menuId;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
