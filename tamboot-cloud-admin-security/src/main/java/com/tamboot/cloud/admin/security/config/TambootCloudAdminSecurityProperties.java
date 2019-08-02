package com.tamboot.cloud.admin.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.security")
public class TambootCloudAdminSecurityProperties {
    private boolean refreshPermissionOnStartUp;

    public boolean isRefreshPermissionOnStartUp() {
        return refreshPermissionOnStartUp;
    }

    public void setRefreshPermissionOnStartUp(boolean refreshPermissionOnStartUp) {
        this.refreshPermissionOnStartUp = refreshPermissionOnStartUp;
    }
}
