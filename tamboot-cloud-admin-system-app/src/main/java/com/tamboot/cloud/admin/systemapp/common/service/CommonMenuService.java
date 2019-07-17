package com.tamboot.cloud.admin.systemapp.common.service;

import com.tamboot.cloud.admin.systemapp.ms.response.MenuTree;

import java.util.List;

public interface CommonMenuService {
    /**
     * Build menu tree according to roles of login user
     * @return menu tree, never null
     */
    List<MenuTree> tree();
}
