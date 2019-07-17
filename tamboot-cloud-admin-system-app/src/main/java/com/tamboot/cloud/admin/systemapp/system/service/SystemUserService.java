package com.tamboot.cloud.admin.systemapp.system.service;

import com.github.pagehelper.Page;
import com.tamboot.cloud.admin.systemapp.system.dto.SystemUserDto;
import com.tamboot.cloud.admin.systemapp.system.form.AssignRolesForm;
import com.tamboot.cloud.admin.systemapp.system.form.CreateUserForm;
import com.tamboot.cloud.admin.systemapp.system.form.PageUserForm;
import com.tamboot.cloud.admin.systemapp.system.form.ResetPasswordForm;
import com.tamboot.cloud.admin.systemapp.system.model.SystemUserModel;

public interface SystemUserService {
    /**
     * Reset password for specified user
     * @param form {@code form.userId} required<br/>
     *              {@code form.password} required
     * @return true if success to reset, otherwise false
     * @throws com.tamboot.web.core.BusinessException if required form fields not set, or form.password format not correct, or user not found.
     */
    boolean resetPassword(ResetPasswordForm form);

    /**
     * Page user dto
     * @param form {@code form.usernameLike} optional, keyword in username<br/>
     *              {@code form.status} optional, user status<br>
     *              {@code form.pageNum} optional, default is 1<br>
     *              {@code form.pageSize} optional, default is 20
     * @return page of user dto
     */
    Page<SystemUserDto> pageDto(PageUserForm form);

    /**
     * Enable specified user
     * @param userId required
     * @return true if success, otherwise false
     * @throws com.tamboot.web.core.BusinessException if {@code userId} is null, or user not found, or user is enabled
     */
    boolean enable(Long userId);

    /**
     * Disable specified user
     * @param userId required
     * @return true if success, otherwise false
     * @throws com.tamboot.web.core.BusinessException if {@code userId} is null, or user not found, or user is disabled
     */
    boolean disable(Long userId);

    /**
     * Create a user
     * @param form {@code form.username} required<br/>
     *              {@code form.password} required
     * @return the created user
     * @throws com.tamboot.web.core.BusinessException if required form fields not set, or username exists, or {@code form.password} format wrong
     */
    SystemUserModel create(CreateUserForm form);

    /**
     * Assign roles to specified user
     * @param form {@code form.userId} required<br>
     *              {@code form.roleCodes} requireds
     * @return true if success, otherwise false
     * @throws com.tamboot.web.core.BusinessException if required form fields not set, or user not exists
     */
    boolean assignRoles(AssignRolesForm form);
}
