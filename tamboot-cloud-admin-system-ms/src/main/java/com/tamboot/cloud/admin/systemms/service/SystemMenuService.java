package com.tamboot.cloud.admin.systemms.service;

import com.tamboot.cloud.admin.systemms.dto.MenuTree;
import com.tamboot.cloud.admin.systemms.model.SystemMenuModel;

import java.util.List;

public interface SystemMenuService {

    /**
     * Build menu tree using given {@code menus}
     * @param menus menu items
     * @return menu tree, never null
     */
    List<MenuTree> buildMenuTree(List<SystemMenuModel> menus);

    /**
     * Build menu tree for specified user
     * @param userId required
     * @return menu tree, never null
     */
    List<MenuTree> treeForUser(Long userId);
}
