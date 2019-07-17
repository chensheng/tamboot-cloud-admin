package com.tamboot.cloud.admin.systemapp.system.form;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AssignMenusForm {
    @NotNull(message = "请选择角色")
    private Long roleId;

    private List<Long> menuIds;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Long> menuIds) {
        this.menuIds = menuIds;
    }
}
