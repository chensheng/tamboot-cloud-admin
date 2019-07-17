package com.tamboot.cloud.admin.manageapp.system.form;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class CreatePermissionForm {
    @NotEmpty(message = "请输入URL")
    private String url;

    @NotEmpty(message = "请选择角色")
    private List<String> roleCodes;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getRoleCodes() {
        return roleCodes;
    }

    public void setRoleCodes(List<String> roleCodes) {
        this.roleCodes = roleCodes;
    }
}
