package com.tamboot.cloud.admin.systemsvc.service.impl;

import com.tamboot.cloud.admin.systemsvc.mapper.SystemUserRoleMapper;
import com.tamboot.cloud.admin.systemsvc.model.SystemUserRoleModel;
import com.tamboot.cloud.admin.systemsvc.service.SystemRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SystemRoleServiceImpl implements SystemRoleService {
    @Autowired
    private SystemUserRoleMapper systemUserRoleMapper;

    @Override
    public String[] findRolesForUser(Long userId) {
        if (userId == null) {
            return new String[0];
        }

        List<SystemUserRoleModel> userRoles = systemUserRoleMapper.selectAllByUserId(userId);
        if (CollectionUtils.isEmpty(userRoles)) {
            return new String[0];
        }

        String[] roleCodes = new String[userRoles.size()];
        for (int i=0; i<roleCodes.length; i++) {
            roleCodes[i] = userRoles.get(i).getRoleCode();
        }
        return roleCodes;
    }

}
