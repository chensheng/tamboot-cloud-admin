package com.tamboot.cloud.admin.systemapp.system.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UpdatePermissionForm {
    @NotNull(message = "id不能为空")
    private Long id;

    @NotEmpty(message = "请输入URL")
    private String url;

    @NotEmpty(message = "请选择角色")
    private List<String> roleCodes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
