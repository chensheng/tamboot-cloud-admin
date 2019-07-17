package com.tamboot.cloud.admin.manageapp.system.service;

import com.tamboot.cloud.admin.manageapp.api.response.MenuTree;
import com.tamboot.cloud.admin.manageapp.system.form.CreateMenuForm;
import com.tamboot.cloud.admin.manageapp.system.form.UpdateMenuForm;
import com.tamboot.cloud.admin.manageapp.system.model.SystemMenuModel;

import java.util.List;

public interface SystemMenuService {
    /**
     * Create a menu item
     * @param form {@code form.name} required<br>
     *              {@code form.path} required<br>
     *              {@code form.locale} optional<br>
     *              {@code form.icon} optional<br>
     *              {@code form.parent} optional
     * @return created menu item
     * @throws com.tamboot.web.core.BusinessException if required form fields not set, or parent menu not exists
     */
    SystemMenuModel create(CreateMenuForm form);

    /**
     * Update a menu item
     * @param form {@code form.id} required<br>
     *              {@code form.name} required<br>
     *              {@code form.path} required<br>
     *              {@code form.locale} optional<br>
     *              {@code form.icon} optional
     * @return updated menu item
     * @throws com.tamboot.web.core.BusinessException if required form fields not set
     */
    SystemMenuModel update(UpdateMenuForm form);

    /**
     * Delete a menu item which has no children, and also delete related {@code SystemRoleMenuModel} records.
     * @param id required, menu id
     * @return true if success, otherwise false
     * @throws com.tamboot.web.core.BusinessException if {@code id} is null, or menu item not exists
     */
    boolean delete(Long id);

    /**
     * Build menu tree using given {@code menus}
     * @param menus menu items
     * @return menu tree, never null
     */
    List<MenuTree> buildMenuTree(List<SystemMenuModel> menus);

    /**
     * Build menu tree using all menu items in database
     * @return menu tree, never null
     */
    List<MenuTree> tree();

    /**
     * Build menu tree for specified role
     * @param roleId required
     * @return menu tree, never null
     * @throws com.tamboot.web.core.BusinessException if {@code roleId} is null, or role not exists
     */
    List<MenuTree> treeForRole(Long roleId);

    /**
     * Find available menu ids for specified role
     * @param roleId required
     * @return menu ids, never null
     * @throws com.tamboot.web.core.BusinessException if {@code roleId} is null, or role not exists
     */
    List<Long> findRoleMenus(Long roleId);
}
