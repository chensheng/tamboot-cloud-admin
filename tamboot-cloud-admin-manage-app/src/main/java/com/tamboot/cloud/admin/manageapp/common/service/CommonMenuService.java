package com.tamboot.cloud.admin.manageapp.common.service;

import com.tamboot.cloud.admin.manageapp.api.response.MenuTree;

import java.util.List;

public interface CommonMenuService {
    /**
     * Build menu tree according to roles of login user
     * @return menu tree, never null
     */
    List<MenuTree> tree();
}
