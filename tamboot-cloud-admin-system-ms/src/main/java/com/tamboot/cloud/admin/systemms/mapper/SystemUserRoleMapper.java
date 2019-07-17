package com.tamboot.cloud.admin.systemms.mapper;

import com.tamboot.cloud.admin.systemms.model.SystemUserRoleModel;
import com.tamboot.mybatis.provider.CommonMapper;

import java.util.List;

public interface SystemUserRoleMapper extends CommonMapper<SystemUserRoleModel, Long> {
    List<SystemUserRoleModel> selectAllByUserId(Long userId);
}
