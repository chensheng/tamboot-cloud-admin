package com.tamboot.cloud.admin.systemms.service;

public interface SystemRoleService {
    /**
     * Find roles for specified user
     * @param userId
     * @return role code array, never null
     */
    String[] findRolesForUser(Long userId);
}
