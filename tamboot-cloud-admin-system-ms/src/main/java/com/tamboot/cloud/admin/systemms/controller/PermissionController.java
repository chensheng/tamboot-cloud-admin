package com.tamboot.cloud.admin.systemms.controller;

import com.tamboot.cloud.admin.systemms.dto.RoleBasedPermission;
import com.tamboot.cloud.admin.systemms.service.SystemPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private SystemPermissionService systemPermissionService;

    @GetMapping("/findAllRoleBasedPermissions")
    public List<RoleBasedPermission> findAllRoleBasedPermissions() {
        return systemPermissionService.findAllRoleBasedPermissions();
    }
}
