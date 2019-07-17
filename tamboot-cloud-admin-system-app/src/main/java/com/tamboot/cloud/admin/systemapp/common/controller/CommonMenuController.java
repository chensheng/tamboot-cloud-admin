package com.tamboot.cloud.admin.systemapp.common.controller;

import com.tamboot.cloud.admin.systemapp.common.service.CommonMenuService;
import com.tamboot.cloud.admin.systemapp.ms.response.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${spring.application.name}/common/menu")
public class CommonMenuController {
    @Autowired
    private CommonMenuService commonMenuService;

    @GetMapping("/tree")
    public List<MenuTree> tree() {
        return commonMenuService.tree();
    }
}
