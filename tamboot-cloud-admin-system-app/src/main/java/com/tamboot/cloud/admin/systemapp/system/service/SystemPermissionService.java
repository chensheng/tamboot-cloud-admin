package com.tamboot.cloud.admin.systemapp.system.service;

import com.github.pagehelper.Page;
import com.tamboot.cloud.admin.systemapp.system.dto.SystemPermissionDto;
import com.tamboot.cloud.admin.systemapp.system.form.CreatePermissionForm;
import com.tamboot.cloud.admin.systemapp.system.form.PagePermissionForm;
import com.tamboot.cloud.admin.systemapp.system.form.UpdatePermissionForm;
import com.tamboot.cloud.admin.systemapp.system.model.SystemPermissionModel;
import com.tamboot.security.permission.RoleBasedPermission;

import java.util.List;

public interface SystemPermissionService {
    /**
     * Find all role based permission configs
     * @return permission list, never null
     */
    List<RoleBasedPermission> findAllRoleBasedPermissions();

    /**
     * Create a permission item
     * @param form {@code form.url} required<br>
     *              {@code form.roles} required
     * @return permission item
     * @throws com.tamboot.web.core.BusinessException if required form fields not set, or {@code form.url} already exists
     */
    SystemPermissionModel create(CreatePermissionForm form);

    /**
     * Update a permission item
     * @param form {@code form.id} required<br>
     *              {@code form.url} required<br>
     *              {@code form.roles} required
     * @return updated permission item
     * @throws com.tamboot.web.core.BusinessException if required form fields not set, or {@code form.url} already exists
     */
    SystemPermissionModel update(UpdatePermissionForm form);

    /**
     * Page permission items
     * @param form {@code form.urlLike} optional<br>
     *              {@code form.roleCode} optional
     * @return page of permission items
     */
    Page<SystemPermissionModel> page(PagePermissionForm form);

    /**
     * Page permission DTOs
     * @param form {@code form.urlLike} optional<br>
     *              {@code form.roleCode} optional
     * @return page of permission DTOs
     */
    Page<SystemPermissionDto> pageDto(PagePermissionForm form);

    /**
     * Load permissions from database, and store them to redis.
     * @return newest permissions
     */
    List<RoleBasedPermission> refresh();

    /**
     * Delete a permission item
     * @param id required
     * @return true if success, otherwise false
     * @throws com.tamboot.web.core.BusinessException if {@code id} is null, or permission item not exists
     */
    boolean delete(Long id);
}
