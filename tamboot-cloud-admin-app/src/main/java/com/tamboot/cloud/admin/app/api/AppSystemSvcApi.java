package com.tamboot.cloud.admin.app.api;

import com.tamboot.cloud.admin.app.api.response.UserInfo;
import com.tamboot.common.web.ApiResponse;
import com.tamboot.security.permission.RoleBasedPermission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AppSystemSvcApi {
    @GetMapping("/user/findByUsername")
    UserInfo findUserByUsername(@RequestParam("username") String username);

    @GetMapping("/role/findRolesForUser")
    String[] findRolesForUser(@RequestParam("userId") Long userId);

    @GetMapping("/permission/findAllRoleBasedPermissions")
    ApiResponse<List<RoleBasedPermission>> findAllRoleBasedPermissions();
}
