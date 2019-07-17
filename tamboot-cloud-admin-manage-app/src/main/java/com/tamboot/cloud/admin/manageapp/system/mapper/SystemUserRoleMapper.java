package com.tamboot.cloud.admin.manageapp.system.mapper;

import com.tamboot.cloud.admin.manageapp.system.model.SystemUserRoleModel;
import com.tamboot.mybatis.provider.CommonMapper;

public interface SystemUserRoleMapper extends CommonMapper<SystemUserRoleModel, Long> {
    int deleteByRoleCode(String roleCode);

    int deleteByUserId(Long userId);
}
