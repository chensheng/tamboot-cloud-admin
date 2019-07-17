package com.tamboot.cloud.admin.systemsvc.mapper;

import com.tamboot.cloud.admin.systemsvc.model.SystemUserModel;
import com.tamboot.mybatis.provider.CommonMapper;

public interface SystemUserMapper extends CommonMapper<SystemUserModel, Long> {
    SystemUserModel selectOneByUsername(String username);
}
