package com.tamboot.cloud.admin.systemapp.common.controller;

import com.tamboot.cloud.admin.systemapp.common.form.UpdatePasswordForm;
import com.tamboot.cloud.admin.systemapp.common.service.CommonUserService;
import com.tamboot.security.core.TambootUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("${spring.application.name}/common/user")
public class CommonUserController {
    @Autowired
    private CommonUserService commonUserService;

    @GetMapping("/details")
    public TambootUserDetails details() {
        return commonUserService.details();
    }

    @GetMapping("/refreshToken")
    public void refreshToken(HttpServletRequest request) {
        commonUserService.refreshToken(request);
    }

    @PostMapping("/updatePassword")
    public void updatePassword(@RequestBody @Valid UpdatePasswordForm form) {
        commonUserService.updatePassword(form);
    }
}
