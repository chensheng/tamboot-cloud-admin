package com.tamboot.cloud.admin.systemsvc.controller;

import com.tamboot.cloud.admin.systemsvc.service.SystemRoleService;
import com.tamboot.web.annotation.IgnoreResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private SystemRoleService systemRoleService;

    @GetMapping("/findRolesForUser")
    @IgnoreResponseWrapper
    public String[] findRolesForUser(Long userId) {
        return systemRoleService.findRolesForUser(userId);
    }
}
