package com.tamboot.cloud.admin.systemsvc.service;

import com.tamboot.cloud.admin.systemsvc.model.SystemUserModel;

public interface SystemUserService {
    /**
     * Find a user by username
     * @param username
     * @return user if found, otherwise null
     */
    SystemUserModel findByUsername(String username);
}
