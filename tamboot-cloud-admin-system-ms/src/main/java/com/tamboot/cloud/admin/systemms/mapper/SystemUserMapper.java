package com.tamboot.cloud.admin.systemms.mapper;

import com.tamboot.cloud.admin.systemms.model.SystemUserModel;
import com.tamboot.mybatis.provider.CommonMapper;

public interface SystemUserMapper extends CommonMapper<SystemUserModel, Long> {
    SystemUserModel selectOneByUsername(String username);
}
