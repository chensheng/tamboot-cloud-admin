package com.tamboot.cloud.admin.systemapp.system.conroller;

import com.github.pagehelper.Page;
import com.tamboot.cloud.admin.systemapp.system.dto.SystemUserDto;
import com.tamboot.cloud.admin.systemapp.system.form.AssignRolesForm;
import com.tamboot.cloud.admin.systemapp.system.form.CreateUserForm;
import com.tamboot.cloud.admin.systemapp.system.form.PageUserForm;
import com.tamboot.cloud.admin.systemapp.system.form.ResetPasswordForm;
import com.tamboot.cloud.admin.systemapp.system.model.SystemUserModel;
import com.tamboot.cloud.admin.systemapp.system.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("${spring.application.name}/system/user")
public class SystemUserController {
    @Autowired
    private SystemUserService systemUserService;

    @GetMapping("/page")
    public Page<SystemUserDto> page(@Valid PageUserForm form) {
        return systemUserService.pageDto(form);
    }

    @PostMapping("/resetPassword")
    public boolean resetPassword(@RequestBody @Valid ResetPasswordForm form) {
        return systemUserService.resetPassword(form);
    }

    @PostMapping("/enable/{userId}")
    public boolean enable(@PathVariable Long userId) {
        return systemUserService.enable(userId);
    }

    @PostMapping("/disable/{userId}")
    public boolean disable(@PathVariable Long userId) {
        return systemUserService.disable(userId);
    }

    @PostMapping("/create")
    public SystemUserModel create(@RequestBody @Valid CreateUserForm form) {
        return systemUserService.create(form);
    }

    @PostMapping("/assignRoles")
    public boolean assignRoles(@RequestBody @Valid AssignRolesForm form) {
        return systemUserService.assignRoles(form);
    }
}
