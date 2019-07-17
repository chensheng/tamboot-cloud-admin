package com.tamboot.cloud.admin.systemapp.system.mapper;

import com.tamboot.cloud.admin.systemapp.system.model.SystemRoleMenuModel;
import com.tamboot.mybatis.provider.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface SystemRoleMenuMapper extends CommonMapper<SystemRoleMenuModel, Long> {
    int deleteByRoleCode(String roleCode);

    int deleteByMenuId(Long menuId);

    int deleteByIds(@Param("ids") Collection<Long> ids);

    List<SystemRoleMenuModel> selectAllByRoleCode(String roleCode);
}
