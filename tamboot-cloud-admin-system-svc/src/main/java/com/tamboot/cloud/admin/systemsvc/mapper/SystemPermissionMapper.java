package com.tamboot.cloud.admin.systemsvc.mapper;

import com.tamboot.cloud.admin.systemsvc.model.SystemPermissionModel;
import com.tamboot.mybatis.provider.CommonMapper;

import java.util.List;

public interface SystemPermissionMapper extends CommonMapper<SystemPermissionModel, Long> {
    List<SystemPermissionModel> selectAll();
}
