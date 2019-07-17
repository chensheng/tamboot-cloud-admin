package com.tamboot.cloud.admin.systemsvc.mapper;

import com.tamboot.cloud.admin.systemsvc.model.SystemUserRoleModel;
import com.tamboot.mybatis.provider.CommonMapper;

import java.util.List;

public interface SystemUserRoleMapper extends CommonMapper<SystemUserRoleModel, Long> {
    List<SystemUserRoleModel> selectAllByUserId(Long userId);
}
