package com.tamboot.cloud.admin.manageapp.system.form;

import com.tamboot.common.web.PageForm;

public class PageRoleForm extends PageForm {
    private String roleCodeLike;

    private String roleNameLike;

    public String getRoleCodeLike() {
        return roleCodeLike;
    }

    public void setRoleCodeLike(String roleCodeLike) {
        this.roleCodeLike = roleCodeLike;
    }

    public String getRoleNameLike() {
        return roleNameLike;
    }

    public void setRoleNameLike(String roleNameLike) {
        this.roleNameLike = roleNameLike;
    }
}
