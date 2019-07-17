package com.tamboot.cloud.admin.manageapp.system.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AssignRolesForm {
    @NotNull(message = "请选择用户")
    private Long userId;

    @NotEmpty(message = "请选择角色")
    private List<String> roleCodes;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getRoleCodes() {
        return roleCodes;
    }

    public void setRoleCodes(List<String> roleCodes) {
        this.roleCodes = roleCodes;
    }
}
