package com.tamboot.cloud.admin.systemapp.system.service.impl;

import com.github.pagehelper.Page;
import com.tamboot.cloud.admin.systemapp.system.condition.PageRoleCondition;
import com.tamboot.cloud.admin.systemapp.system.form.AssignMenusForm;
import com.tamboot.cloud.admin.systemapp.system.form.CreateRoleForm;
import com.tamboot.cloud.admin.systemapp.system.form.PageRoleForm;
import com.tamboot.cloud.admin.systemapp.system.form.UpdateRoleForm;
import com.tamboot.cloud.admin.systemapp.system.mapper.SystemMenuMapper;
import com.tamboot.cloud.admin.systemapp.system.mapper.SystemRoleMapper;
import com.tamboot.cloud.admin.systemapp.system.mapper.SystemRoleMenuMapper;
import com.tamboot.cloud.admin.systemapp.system.mapper.SystemUserRoleMapper;
import com.tamboot.cloud.admin.systemapp.system.model.SystemMenuModel;
import com.tamboot.cloud.admin.systemapp.system.model.SystemRoleMenuModel;
import com.tamboot.cloud.admin.systemapp.system.model.SystemRoleModel;
import com.tamboot.cloud.admin.systemapp.system.service.SystemRoleService;
import com.tamboot.web.core.BusinessException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class SystemRoleServiceImpl implements SystemRoleService {
    @Autowired
    private SystemRoleMapper systemRoleMapper;

    @Autowired
    private SystemUserRoleMapper systemUserRoleMapper;

    @Autowired
    private SystemRoleMenuMapper systemRoleMenuMapper;

    @Autowired
    private SystemMenuMapper systemMenuMapper;

    @Override
    @Transactional(readOnly = false)
    public SystemRoleModel create(CreateRoleForm form) {
        SystemRoleModel existingRole = systemRoleMapper.selectOneByRoleCode(form.getRoleCode());
        if (existingRole != null) {
            throw new BusinessException("角色编码已存在");
        }

        SystemRoleModel role = new SystemRoleModel();
        role.setRoleCode(form.getRoleCode());
        role.setRoleName(form.getRoleName());
        role.setRoleDesc(form.getRoleDesc());
        systemRoleMapper.insert(role);
        return role;
    }

    @Override
    public Page<SystemRoleModel> page(PageRoleForm form) {
        PageRoleCondition condition = new PageRoleCondition();
        BeanUtils.copyProperties(form, condition);
        return systemRoleMapper.pageByCondition(form.getPageNum(), form.getPageSize(), condition);
    }

    @Override
    @Transactional(readOnly = false)
    public boolean delete(Long id) {
        if (id == null) {
            throw new BusinessException("请选择要删除的角色");
        }

        SystemRoleModel role = systemRoleMapper.selectOneById(id);
        if (role == null) {
            throw new BusinessException("角色不存在");
        }

        systemRoleMapper.deleteById(id);
        systemUserRoleMapper.deleteByRoleCode(role.getRoleCode());
        systemRoleMenuMapper.deleteByRoleCode(role.getRoleCode());
        return true;
    }

    @Override
    @Transactional(readOnly = false)
    public SystemRoleModel update(UpdateRoleForm form) {
        SystemRoleModel role = systemRoleMapper.selectOneById(form.getId());
        if (role == null) {
            throw new BusinessException("角色不存在");
        }

        role.setRoleName(form.getRoleName());
        role.setRoleDesc(form.getRoleDesc());
        systemRoleMapper.updateById(role);
        return role;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean assignMenus(AssignMenusForm form) {
        SystemRoleModel role = systemRoleMapper.selectOneById(form.getRoleId());
        if (role == null) {
            throw new BusinessException("角色不存在");
        }
        if (CollectionUtils.isEmpty(form.getMenuIds())) {
            systemRoleMenuMapper.deleteByRoleCode(role.getRoleCode());
            return true;
        }

        List<SystemMenuModel> newMenus = systemMenuMapper.selectAllByIds(form.getMenuIds());
        if (CollectionUtils.isEmpty(newMenus)) {
            systemRoleMenuMapper.deleteByRoleCode(role.getRoleCode());
            return true;
        }

        Set<Long> newMenuIds = new HashSet<Long>();
        for (SystemMenuModel menu : newMenus) {
            newMenuIds.add(menu.getId());
        }

        Set<Long> toInsertMenuIds = new HashSet<Long>();
        Set<Long> toDeleteRoleMenuIds = new HashSet<Long>();
        toInsertMenuIds.addAll(newMenuIds);
        List<SystemRoleMenuModel> oldRoleMenus = systemRoleMenuMapper.selectAllByRoleCode(role.getRoleCode());
        if (!CollectionUtils.isEmpty(oldRoleMenus)) {
            for (SystemRoleMenuModel roleMenu : oldRoleMenus) {
                if (newMenuIds.contains(roleMenu.getMenuId())) {
                    toInsertMenuIds.remove(roleMenu.getMenuId());
                } else {
                    toDeleteRoleMenuIds.add(roleMenu.getId());
                }
            }
        }

        if (!CollectionUtils.isEmpty(toDeleteRoleMenuIds)) {
            systemRoleMenuMapper.deleteByIds(toDeleteRoleMenuIds);
        }
        if (!CollectionUtils.isEmpty(toInsertMenuIds)) {
            for (Long menuId : toInsertMenuIds) {
                SystemRoleMenuModel roleMenu = new SystemRoleMenuModel();
                roleMenu.setRoleCode(role.getRoleCode());
                roleMenu.setMenuId(menuId);
                systemRoleMenuMapper.insert(roleMenu);
            }
        }
        return true;
    }

    @Override
    public List<SystemRoleModel> list() {
        return systemRoleMapper.selectAll();
    }
}
