package com.tamboot.cloud.admin.systemms.service;

import com.tamboot.cloud.admin.systemms.dto.RoleBasedPermission;

import java.util.List;

public interface SystemPermissionService {
    /**
     * Find all role based permission configs
     * @return permission list, never null
     */
    List<RoleBasedPermission> findAllRoleBasedPermissions();
}
