package com.tamboot.cloud.admin.manageapp.system.conroller;

import com.tamboot.cloud.admin.manageapp.api.response.MenuTree;
import com.tamboot.cloud.admin.manageapp.system.form.CreateMenuForm;
import com.tamboot.cloud.admin.manageapp.system.form.UpdateMenuForm;
import com.tamboot.cloud.admin.manageapp.system.model.SystemMenuModel;
import com.tamboot.cloud.admin.manageapp.system.service.SystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/system/menu")
public class SystemMenuController {
    @Autowired
    private SystemMenuService systemMenuService;

    @PostMapping("/create")
    public SystemMenuModel create(@RequestBody @Valid CreateMenuForm form) {
        return systemMenuService.create(form);
    }

    @PostMapping("/update")
    public SystemMenuModel update(@RequestBody @Valid UpdateMenuForm form) {
        return systemMenuService.update(form);
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return systemMenuService.delete(id);
    }

    @GetMapping("/tree")
    public List<MenuTree> tree() {
        return systemMenuService.tree();
    }

    @GetMapping("/treeForRole")
    public List<MenuTree> treeForRole(Long roleId) {
        return systemMenuService.treeForRole(roleId);
    }

    @GetMapping("/roleMenus")
    public List<Long> roleMenus(Long roleId) {
        return systemMenuService.findRoleMenus(roleId);
    }
}
