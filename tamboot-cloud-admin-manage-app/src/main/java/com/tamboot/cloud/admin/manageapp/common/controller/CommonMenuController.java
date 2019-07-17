package com.tamboot.cloud.admin.manageapp.common.controller;

import com.tamboot.cloud.admin.manageapp.common.service.CommonMenuService;
import com.tamboot.cloud.admin.manageapp.api.response.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/common/menu")
public class CommonMenuController {
    @Autowired
    private CommonMenuService commonMenuService;

    @GetMapping("/tree")
    public List<MenuTree> tree() {
        return commonMenuService.tree();
    }
}
