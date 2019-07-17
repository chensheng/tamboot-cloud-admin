package com.tamboot.cloud.admin.systemapp.system.form;

import com.tamboot.cloud.admin.systemapp.constants.RegExpression;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ResetPasswordForm {
    @NotNull(message = "请选择用户")
    private Long userId;

    @NotEmpty(message = "请输入密码")
    @Pattern(regexp = RegExpression.PASSWORD, message = "密码必须由数字、字母、特殊字符(_#@!)组成，且不能少于8位！")
    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
