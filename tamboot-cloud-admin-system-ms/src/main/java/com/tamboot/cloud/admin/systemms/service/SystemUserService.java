package com.tamboot.cloud.admin.systemms.service;

import com.tamboot.cloud.admin.systemms.model.SystemUserModel;

public interface SystemUserService {
    /**
     * Find a user by username
     * @param username
     * @return user if found, otherwise null
     */
    SystemUserModel findByUsername(String username);
}
