package com.tamboot.cloud.admin.systemsvc.controller;

import com.tamboot.cloud.admin.systemsvc.dto.MenuTree;
import com.tamboot.cloud.admin.systemsvc.service.SystemMenuService;
import com.tamboot.web.annotation.IgnoreResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private SystemMenuService systemMenuService;

    @GetMapping("/treeForUser")
    public List<MenuTree> treeForUser(Long userId) {
        return systemMenuService.treeForUser(userId);
    }
}
