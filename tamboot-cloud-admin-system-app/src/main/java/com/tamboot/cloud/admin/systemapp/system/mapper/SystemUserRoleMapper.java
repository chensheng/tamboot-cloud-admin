package com.tamboot.cloud.admin.systemapp.system.mapper;

import com.tamboot.cloud.admin.systemapp.system.model.SystemUserRoleModel;
import com.tamboot.mybatis.provider.CommonMapper;

public interface SystemUserRoleMapper extends CommonMapper<SystemUserRoleModel, Long> {
    int deleteByRoleCode(String roleCode);

    int deleteByUserId(Long userId);
}
