package com.tamboot.cloud.admin.systemapp.system.condition;

public class PagePermissionCondition {
    private String urlLike;

    private String roleCode;

    public String getUrlLike() {
        return urlLike;
    }

    public void setUrlLike(String urlLike) {
        this.urlLike = urlLike;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
