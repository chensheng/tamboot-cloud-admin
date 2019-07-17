package com.tamboot.cloud.admin.systemsvc.service.impl;

import com.tamboot.cloud.admin.systemsvc.dto.RoleBasedPermission;
import com.tamboot.cloud.admin.systemsvc.mapper.SystemPermissionMapper;
import com.tamboot.cloud.admin.systemsvc.model.SystemPermissionModel;
import com.tamboot.cloud.admin.systemsvc.service.SystemPermissionService;
import com.tamboot.common.tools.text.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class SystemPermissionServiceImpl implements SystemPermissionService {
    @Autowired
    private SystemPermissionMapper systemPermissionMapper;

    @Override
    public List<RoleBasedPermission> findAllRoleBasedPermissions() {
        List<SystemPermissionModel> permissions =  systemPermissionMapper.selectAll();
        if (CollectionUtils.isEmpty(permissions)) {
            return new ArrayList<RoleBasedPermission>(0);
        }

        List<RoleBasedPermission> roleBasedPermissions = new ArrayList<RoleBasedPermission>(permissions.size());
        for (SystemPermissionModel permission : permissions) {
            roleBasedPermissions.add(new RoleBasedPermission(permission.getUrl())
                    .addRoles(TextUtil.splitByComma(permission.getRoles())));
        }
        return roleBasedPermissions;
    }

}
