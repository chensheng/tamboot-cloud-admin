package com.tamboot.cloud.admin.systemapp.system.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateRoleForm {
    @NotNull(message = "请选择角色")
    private Long id;

    @NotEmpty(message = "请输入角色名称")
    private String roleName;

    private String roleDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
