package com.tamboot.cloud.admin.systemapp.system.form;

import com.tamboot.common.web.PageForm;

public class PageUserForm extends PageForm {
    private String usernameLike;

    private Integer status;

    private String roleCode;

    public String getUsernameLike() {
        return usernameLike;
    }

    public void setUsernameLike(String usernameLike) {
        this.usernameLike = usernameLike;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
