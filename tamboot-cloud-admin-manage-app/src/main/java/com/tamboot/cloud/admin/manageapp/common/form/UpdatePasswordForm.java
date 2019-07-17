package com.tamboot.cloud.admin.manageapp.common.form;

import com.tamboot.cloud.admin.manageapp.constants.RegExpression;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UpdatePasswordForm {
    @NotEmpty(message = "请输入原密码")
    private String oldPassword;

    @NotEmpty(message = "请输入新密码")
    @Pattern(regexp = RegExpression.PASSWORD, message = "密码必须由数字、字母、特殊字符(_#@!)组成，且不能少于8位！")
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
