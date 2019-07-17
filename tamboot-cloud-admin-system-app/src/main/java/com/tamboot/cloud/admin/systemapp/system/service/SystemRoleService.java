package com.tamboot.cloud.admin.systemapp.system.service;

import com.github.pagehelper.Page;
import com.tamboot.cloud.admin.systemapp.system.form.AssignMenusForm;
import com.tamboot.cloud.admin.systemapp.system.form.CreateRoleForm;
import com.tamboot.cloud.admin.systemapp.system.form.PageRoleForm;
import com.tamboot.cloud.admin.systemapp.system.form.UpdateRoleForm;
import com.tamboot.cloud.admin.systemapp.system.model.SystemRoleModel;

import java.util.List;

public interface SystemRoleService {
    /**
     * Create a role
     * @param form {@code form.roleCode} required<br/>
     *              {@code from.roleName} required<br/>
     *              {@code form.roleDesc} optional
     * @return role
     * @throws com.tamboot.web.core.BusinessException if required form fields not set, or {@code form.roleCode} format is wrong, or {@code form.roleCode} exists.
     */
    SystemRoleModel create(CreateRoleForm form);

    /**
     * Page all roles
     * @param form {@code form.roleCodeLike} optional, keyword in role code<br>
     *              {@code from roleNameLike} optional, keyword in role name<br>
     *              {@code form.pageNum} optional, default is 1<br>
     *              {@code form.pageSize} optional, default is 20
     * @return role page
     */
    Page<SystemRoleModel> page(PageRoleForm form);

    /**
     * Delete role and related {@code SystemUserRoleModel}, {@code SystemRoleMenuModel} records
     * @param id required, role id
     * @return true if success, otherwise false
     * @throws com.tamboot.web.core.BusinessException if {@code id} is null, or role not exists
     */
    boolean delete(Long id);

    /**
     * Update role's name and description
     * @param form {@code form.id} required<br>
     *              {@code form.roleName} required<br>
     *              {@code form.roleDesc} optional
     * @return updated role
     * @throws com.tamboot.web.core.BusinessException is required form fields not set, or role not exists, or role not exists
     */
    SystemRoleModel update(UpdateRoleForm form);

    /**
     * Assign menus to specified role, and delete old assigned menus.
     * @param form {@code form.roleId} required<br>
     *              {@code form.menuIds} optional
     * @return true if success, otherwise false
     * @throws com.tamboot.web.core.BusinessException if required form fields not set, or role not exists
     */
    boolean assignMenus(AssignMenusForm form);

    List<SystemRoleModel> list();
}
