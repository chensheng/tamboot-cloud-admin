package com.tamboot.cloud.admin.systemsvc.controller;

import com.tamboot.cloud.admin.systemsvc.dto.RoleBasedPermission;
import com.tamboot.cloud.admin.systemsvc.service.SystemPermissionService;
import com.tamboot.web.annotation.IgnoreResponseWrapper;
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
