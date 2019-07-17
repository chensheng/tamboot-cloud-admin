package com.tamboot.cloud.admin.manageapp.system.service.impl;

import com.tamboot.cloud.admin.manageapp.api.response.MenuTree;
import com.tamboot.cloud.admin.manageapp.system.form.CreateMenuForm;
import com.tamboot.cloud.admin.manageapp.system.form.UpdateMenuForm;
import com.tamboot.cloud.admin.manageapp.system.mapper.SystemMenuMapper;
import com.tamboot.cloud.admin.manageapp.system.mapper.SystemRoleMapper;
import com.tamboot.cloud.admin.manageapp.system.mapper.SystemRoleMenuMapper;
import com.tamboot.cloud.admin.manageapp.system.model.SystemMenuModel;
import com.tamboot.cloud.admin.manageapp.system.model.SystemRoleModel;
import com.tamboot.cloud.admin.manageapp.system.service.SystemMenuService;
import com.tamboot.common.tools.text.TextUtil;
import com.tamboot.web.core.BusinessException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class SystemMenuServiceImpl implements SystemMenuService {
    private static final Comparator<MenuTree> menuTreeComparator;

    @Autowired
    private SystemMenuMapper systemMenuMapper;

    @Autowired
    private SystemRoleMenuMapper systemRoleMenuMapper;

    @Autowired
    private SystemRoleMapper systemRoleMapper;

    @Override
    @Transactional(readOnly = false)
    public SystemMenuModel create(CreateMenuForm form) {
        if (form.getParent() != null) {
            SystemMenuModel parentMenu = systemMenuMapper.selectOneById(form.getParent());
            if (parentMenu == null) {
                throw new BusinessException("父菜单不存在");
            }
        }
        if (form.getOrderIndex() == null) {
            form.setOrderIndex(0);
        }
        if (TextUtil.isEmpty(form.getIcon())) {
            form.setIcon(null);
        }

        SystemMenuModel menu = new SystemMenuModel();
        BeanUtils.copyProperties(form, menu);
        systemMenuMapper.insert(menu);
        return menu;
    }

    @Override
    @Transactional(readOnly = false)
    public SystemMenuModel update(UpdateMenuForm form) {
        SystemMenuModel menu = systemMenuMapper.selectOneById(form.getId());
        if (menu == null) {
            throw new BusinessException("菜单不存在");
        }
        if (form.getOrderIndex() == null) {
            form.setOrderIndex(0);
        }
        if (TextUtil.isEmpty(form.getIcon())) {
            form.setIcon(null);
        }

        BeanUtils.copyProperties(form, menu);
        systemMenuMapper.updateById(menu);
        return menu;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean delete(Long id) {
        if (id == null) {
            throw new BusinessException("请选择菜单");
        }

        SystemMenuModel menu = systemMenuMapper.selectOneById(id);
        if (menu == null) {
            throw new BusinessException("菜单不存在");
        }

        List<SystemMenuModel> children = systemMenuMapper.selectAllByParent(id);
        if (!CollectionUtils.isEmpty(children)) {
            throw new BusinessException("请先删除子菜单");
        }

        systemMenuMapper.deleteById(id);
        systemRoleMenuMapper.deleteByMenuId(id);
        return true;
    }

    @Override
    public List<MenuTree> buildMenuTree(List<SystemMenuModel> menus) {
        List<MenuTree> menuTree = new ArrayList<MenuTree>();

        if (CollectionUtils.isEmpty(menus)) {
            return menuTree;
        }

        Map<Long, List<SystemMenuModel>> parentAndMenusMemo = new HashMap<Long, List<SystemMenuModel>>();
        for (SystemMenuModel menu : menus) {
            if (menu.getParent() != null) {
                if (!parentAndMenusMemo.containsKey(menu.getParent())) {
                    parentAndMenusMemo.put(menu.getParent(), new ArrayList<SystemMenuModel>());
                }
                parentAndMenusMemo.get(menu.getParent()).add(menu);
                continue;
            }

            MenuTree menuLeaf = new MenuTree();
            BeanUtils.copyProperties(menu, menuLeaf);
            menuLeaf.setChildren(new ArrayList<MenuTree>());
            menuTree.add(menuLeaf);
        }

        menuTree.sort(menuTreeComparator);
        fillMenuTreeChildren(menuTree, parentAndMenusMemo);
        return menuTree;
    }

    @Override
    public List<MenuTree> tree() {
        List<SystemMenuModel> menus = systemMenuMapper.selectAll();
        return buildMenuTree(menus);
    }

    @Override
    public List<MenuTree> treeForRole(Long roleId) {
        if (roleId == null) {
            throw new BusinessException("请选择角色");
        }

        SystemRoleModel role = systemRoleMapper.selectOneById(roleId);
        if (role == null) {
            throw new BusinessException("角色不存在");
        }

        List<SystemMenuModel> menus = systemMenuMapper.selectAllByRoleCodes(Arrays.asList(role.getRoleCode()));
        return buildMenuTree(menus);
    }

    @Override
    public List<Long> findRoleMenus(Long roleId) {
        if (roleId == null) {
            throw new BusinessException("请选择角色");
        }

        SystemRoleModel role = systemRoleMapper.selectOneById(roleId);
        if (role == null) {
            throw new BusinessException("角色不存在");
        }

        return systemMenuMapper.selectAllIdsByRoleCodes(Arrays.asList(role.getRoleCode()));
    }

    private void fillMenuTreeChildren(List<MenuTree> menuTree, Map<Long, List<SystemMenuModel>> parentAndMenusMemo) {
        for (MenuTree menuLeaf : menuTree) {
            if (!parentAndMenusMemo.containsKey(menuLeaf.getId())) {
                continue;
            }

            for (SystemMenuModel menu : parentAndMenusMemo.get(menuLeaf.getId())) {
                MenuTree menuChild = new MenuTree();
                BeanUtils.copyProperties(menu, menuChild);
                menuChild.setChildren(new ArrayList<MenuTree>());
                menuLeaf.getChildren().add(menuChild);
            }
            menuLeaf.getChildren().sort(menuTreeComparator);
            fillMenuTreeChildren(menuLeaf.getChildren(), parentAndMenusMemo);
        }
    }

    static {
        menuTreeComparator = new Comparator<MenuTree>() {

            @Override
            public int compare(MenuTree o1, MenuTree o2) {
                if (o1.getOrderIndex() == null && o2.getOrderIndex() != null) {
                    return -1;
                }
                if (o1.getOrderIndex() != null && o2.getOrderIndex() == null) {
                    return 1;
                }
                if (o1.getOrderIndex() == null && o2.getOrderIndex() == null) {
                    return 0;
                }

                return o1.getOrderIndex().compareTo(o2.getOrderIndex());
            }
        };
    }
}
