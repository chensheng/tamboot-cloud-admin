package com.tamboot.cloud.admin.systemapp.system.form;

import com.tamboot.cloud.admin.systemapp.constants.RegExpression;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CreateRoleForm {
    @NotEmpty(message = "请输入角色编码")
    @Pattern(regexp = RegExpression.ROLE_CODE, message = "角色编码只能由大写字母和下划线组成")
    private String roleCode;

    private String roleName;

    private String roleDesc;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
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
