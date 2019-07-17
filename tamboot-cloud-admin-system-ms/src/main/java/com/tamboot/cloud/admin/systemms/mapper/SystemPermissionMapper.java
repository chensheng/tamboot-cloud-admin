package com.tamboot.cloud.admin.systemms.mapper;

import com.tamboot.cloud.admin.systemms.model.SystemPermissionModel;
import com.tamboot.mybatis.provider.CommonMapper;

import java.util.List;

public interface SystemPermissionMapper extends CommonMapper<SystemPermissionModel, Long> {
    List<SystemPermissionModel> selectAll();
}
