package com.tamboot.cloud.admin.systemapp.system.mapper;

import com.github.pagehelper.Page;
import com.tamboot.cloud.admin.systemapp.system.condition.PageUserCondition;
import com.tamboot.cloud.admin.systemapp.system.dto.SystemUserDto;
import com.tamboot.cloud.admin.systemapp.system.model.SystemUserModel;
import com.tamboot.mybatis.provider.CommonMapper;
import org.apache.ibatis.annotations.Param;

public interface SystemUserMapper extends CommonMapper<SystemUserModel, Long> {
    SystemUserModel selectOneByUsername(String username);

    Page<SystemUserDto> pageDtoByCondition(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("condition") PageUserCondition condition);
}
