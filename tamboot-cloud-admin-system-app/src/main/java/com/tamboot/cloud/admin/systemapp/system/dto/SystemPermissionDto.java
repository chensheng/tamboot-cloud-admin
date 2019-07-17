package com.tamboot.cloud.admin.systemapp.system.dto;

import java.io.Serializable;
import java.util.List;

public class SystemPermissionDto implements Serializable {
    private static final long serialVersionUID = -5157941159619759917L;

    private Long id;

    private String url;

    private List<String> roleCodes;

    private List<String> roleNames;

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

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }
}
