package com.tamboot.cloud.admin.systemms.controller;

import com.tamboot.cloud.admin.systemms.model.SystemUserModel;
import com.tamboot.cloud.admin.systemms.service.SystemUserService;
import com.tamboot.web.annotation.IgnoreResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SystemUserService systemUserService;

    @GetMapping("/findByUsername")
    @IgnoreResponseWrapper
    public SystemUserModel findByUsername(String username) {
        return systemUserService.findByUsername(username);
    }
}
