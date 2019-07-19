package com.tamboot.cloud.admin.systemapp.common.service;

import com.tamboot.cloud.admin.systemapp.common.form.UpdatePasswordForm;
import com.tamboot.security.core.TambootUserDetails;

import javax.servlet.http.HttpServletRequest;

public interface CommonUserService {
    /**
     * Get login user details
     * @return login user details
     */
    TambootUserDetails details();

    /**
     * Refresh login token
     * @param request
     */
    void refreshToken(HttpServletRequest request);

    /**
     * Update password for login user
     * @param form {@code form.oldPassword} required<br/>
     *              {@code form.newPassword} required
     * @return true if success, otherwise false
     * @throws com.tamboot.web.core.BusinessException if required form fields not set, or password format not correct
     */
    boolean updatePassword(UpdatePasswordForm form);
}
