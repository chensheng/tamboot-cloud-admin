package com.tamboot.cloud.admin.systemapp.system.form;

import com.tamboot.common.web.PageForm;

public class PagePermissionForm extends PageForm {
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
