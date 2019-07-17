package com.tamboot.cloud.admin.systemapp.common.service.impl;

import com.tamboot.cloud.admin.systemapp.ms.api.SystemMsMenuApi;
import com.tamboot.cloud.admin.systemapp.common.service.CommonMenuService;
import com.tamboot.cloud.admin.systemapp.ms.response.MenuTree;
import com.tamboot.security.util.SafeSecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonMenuServiceImpl implements CommonMenuService {
    @Autowired
    private SystemMsMenuApi menuApi;

    @Override
    public List<MenuTree> tree() {
        Long userId = SafeSecurityContextHolder.getUserId();
        return menuApi.treeForUser(userId).getData();
    }
}
