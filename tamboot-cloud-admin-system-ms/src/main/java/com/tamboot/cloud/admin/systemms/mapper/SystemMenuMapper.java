package com.tamboot.cloud.admin.systemms.mapper;

import com.tamboot.cloud.admin.systemms.model.SystemMenuModel;
import com.tamboot.mybatis.provider.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface SystemMenuMapper extends CommonMapper<SystemMenuModel, Long> {
    List<SystemMenuModel> selectAllByRoleCodes(@Param("roleCodes") Collection<String> roleCodes);
}
