package com.tamboot.cloud.admin.systemsvc.service.impl;

import com.tamboot.cloud.admin.systemsvc.dto.MenuTree;
import com.tamboot.cloud.admin.systemsvc.mapper.SystemMenuMapper;
import com.tamboot.cloud.admin.systemsvc.model.SystemMenuModel;
import com.tamboot.cloud.admin.systemsvc.service.SystemMenuService;
import com.tamboot.cloud.admin.systemsvc.service.SystemRoleService;
import com.tamboot.common.tools.collection.ArrayUtil;
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
    private SystemRoleService systemRoleService;

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
    public List<MenuTree> treeForUser(Long userId) {
        if (userId == null) {
            return new ArrayList<MenuTree>(0);
        }

        String[] roles = systemRoleService.findRolesForUser(userId);
        List<SystemMenuModel> menuList = systemMenuMapper.selectAllByRoleCodes(ArrayUtil.asList(roles));
        return buildMenuTree(menuList);
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
