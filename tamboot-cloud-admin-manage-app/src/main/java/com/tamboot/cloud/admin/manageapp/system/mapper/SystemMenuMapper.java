package com.tamboot.cloud.admin.manageapp.system.mapper;

import com.tamboot.cloud.admin.manageapp.system.model.SystemMenuModel;
import com.tamboot.mybatis.provider.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface SystemMenuMapper extends CommonMapper<SystemMenuModel, Long> {
    List<SystemMenuModel> selectAllByParent(Long parent);

    List<SystemMenuModel> selectAll();

    List<SystemMenuModel> selectAllByRoleCodes(@Param("roleCodes") Collection<String> roleCodes);

    List<Long> selectAllIdsByRoleCodes(@Param("roleCodes") Collection<String> roleCodes);

    List<SystemMenuModel> selectAllByIds(@Param("ids") List<Long> ids);
}
