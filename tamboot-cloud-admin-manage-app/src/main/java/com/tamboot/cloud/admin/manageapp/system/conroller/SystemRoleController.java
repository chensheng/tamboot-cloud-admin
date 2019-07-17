package com.tamboot.cloud.admin.manageapp.system.conroller;

import com.github.pagehelper.Page;
import com.tamboot.cloud.admin.manageapp.system.form.AssignMenusForm;
import com.tamboot.cloud.admin.manageapp.system.form.CreateRoleForm;
import com.tamboot.cloud.admin.manageapp.system.form.PageRoleForm;
import com.tamboot.cloud.admin.manageapp.system.form.UpdateRoleForm;
import com.tamboot.cloud.admin.manageapp.system.model.SystemRoleModel;
import com.tamboot.cloud.admin.manageapp.system.service.SystemRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/system/role")
public class SystemRoleController {
    @Autowired
    private SystemRoleService systemRoleService;

    @GetMapping("/list")
    public List<SystemRoleModel> list() {
        return systemRoleService.list();
    }

    @GetMapping("/page")
    public Page<SystemRoleModel> page(@Valid PageRoleForm form) {
        return systemRoleService.page(form);
    }

    @PostMapping("/create")
    public SystemRoleModel create(@RequestBody  @Valid CreateRoleForm form) {
        return systemRoleService.create(form);
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return systemRoleService.delete(id);
    }

    @PostMapping("/update")
    public SystemRoleModel update(@RequestBody @Valid UpdateRoleForm form) {
        return systemRoleService.update(form);
    }

    @PostMapping("/assignMenus")
    public boolean assignMenus(@RequestBody @Valid AssignMenusForm form) {
        return systemRoleService.assignMenus(form);
    }
}
