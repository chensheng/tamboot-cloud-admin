package com.tamboot.cloud.admin.systemapp.system.form;

import com.tamboot.cloud.admin.systemapp.constants.RegExpression;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CreateUserForm {
    @NotEmpty(message = "请输入用户名")
    private String username;

    @NotEmpty(message = "请输入密码")
    @Pattern(regexp = RegExpression.PASSWORD, message = "密码必须由数字、字母、特殊字符_#@!组成，且不能少于8位！")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
