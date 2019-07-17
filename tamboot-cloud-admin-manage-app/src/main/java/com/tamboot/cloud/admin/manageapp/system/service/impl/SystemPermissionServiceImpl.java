package com.tamboot.cloud.admin.manageapp.system.service.impl;

import com.github.pagehelper.Page;
import com.tamboot.cloud.admin.manageapp.system.condition.PagePermissionCondition;
import com.tamboot.cloud.admin.manageapp.system.dto.SystemPermissionDto;
import com.tamboot.cloud.admin.manageapp.system.form.CreatePermissionForm;
import com.tamboot.cloud.admin.manageapp.system.form.PagePermissionForm;
import com.tamboot.cloud.admin.manageapp.system.form.UpdatePermissionForm;
import com.tamboot.cloud.admin.manageapp.system.mapper.SystemPermissionMapper;
import com.tamboot.cloud.admin.manageapp.system.mapper.SystemRoleMapper;
import com.tamboot.cloud.admin.manageapp.system.model.SystemPermissionModel;
import com.tamboot.cloud.admin.manageapp.system.model.SystemRoleModel;
import com.tamboot.cloud.admin.manageapp.system.service.SystemPermissionService;
import com.tamboot.common.tools.text.TextUtil;
import com.tamboot.security.permission.RoleBasedPermission;
import com.tamboot.security.permission.RoleBasedPermissionRepository;
import com.tamboot.web.core.BusinessException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class SystemPermissionServiceImpl implements SystemPermissionService {
    @Autowired
    private SystemPermissionMapper systemPermissionMapper;

    @Autowired
    private SystemRoleMapper systemRoleMapper;

    @Autowired
    private RoleBasedPermissionRepository roleBasedPermissionRepository;

    @Override
    public List<RoleBasedPermission> findAllRoleBasedPermissions() {
        List<SystemPermissionModel> permissions =  systemPermissionMapper.selectAll();
        if (CollectionUtils.isEmpty(permissions)) {
            return new ArrayList<RoleBasedPermission>(0);
        }

        List<RoleBasedPermission> roleBasedPermissions = new ArrayList<RoleBasedPermission>(permissions.size());
        for (SystemPermissionModel permission : permissions) {
            roleBasedPermissions.add(new RoleBasedPermission(permission.getUrl())
                    .addRoles(TextUtil.splitByComma(permission.getRoles())));
        }
        return roleBasedPermissions;
    }

    @Override
    @Transactional(readOnly = false)
    public SystemPermissionModel create(CreatePermissionForm form) {
        SystemPermissionModel existingPerm = systemPermissionMapper.selectOneByUrl(form.getUrl());
        if (existingPerm != null) {
            throw new BusinessException("URL已经存在");
        }

        List<SystemRoleModel> roles = systemRoleMapper.selectAllByRoleCodes(form.getRoleCodes());
        if (CollectionUtils.isEmpty(roles)) {
            throw new BusinessException("请选择有效的角色");
        }

        List<String> roleCodes = new ArrayList<String>();
        for (SystemRoleModel role : roles) {
            roleCodes.add(role.getRoleCode());
        }

        SystemPermissionModel permission = new SystemPermissionModel();
        permission.setUrl(form.getUrl());
        permission.setRoles(TextUtil.concatByComma(roleCodes));
        systemPermissionMapper.insert(permission);
        return permission;
    }

    @Override
    @Transactional(readOnly = false)
    public SystemPermissionModel update(UpdatePermissionForm form) {
        SystemPermissionModel permission = systemPermissionMapper.selectOneById(form.getId());
        if (permission == null) {
            throw new BusinessException("权限项不存在");
        }

        SystemPermissionModel existingPerm = systemPermissionMapper.selectOneByUrl(form.getUrl());
        if (existingPerm != null && !existingPerm.getId().equals(form.getId())) {
            throw new BusinessException("URL已存在");
        }

        List<SystemRoleModel> roles = systemRoleMapper.selectAllByRoleCodes(form.getRoleCodes());
        if (CollectionUtils.isEmpty(roles)) {
            throw new BusinessException("请选择有效的角色");
        }

        List<String> roleCodes = new ArrayList<String>();
        for (SystemRoleModel role : roles) {
            roleCodes.add(role.getRoleCode());
        }

        permission.setUrl(form.getUrl());
        permission.setRoles(TextUtil.concatByComma(roleCodes));
        systemPermissionMapper.updateById(permission);
        return permission;
    }

    @Override
    public Page<SystemPermissionModel> page(PagePermissionForm form) {
        PagePermissionCondition condition = new PagePermissionCondition();
        BeanUtils.copyProperties(form, condition);
        return systemPermissionMapper.pageByCondition(form.getPageNum(), form.getPageSize(), condition);
    }

    @Override
    public Page<SystemPermissionDto> pageDto(PagePermissionForm form) {
        Page<SystemPermissionDto> dtoPage = new Page<SystemPermissionDto>();

        PagePermissionCondition condition = new PagePermissionCondition();
        BeanUtils.copyProperties(form, condition);
        Page<SystemPermissionModel> modelPage =  systemPermissionMapper.pageByCondition(form.getPageNum(), form.getPageSize(), condition);

        List<SystemPermissionDto> dtoList = convertToDTOs(modelPage.getResult());
        dtoPage.addAll(dtoList);
        dtoPage.setPages(modelPage.getPages());
        dtoPage.setPageNum(modelPage.getPageNum());
        dtoPage.setPageSize(modelPage.getPageSize());
        dtoPage.setTotal(modelPage.getTotal());
        return dtoPage;
    }

    @Override
    public List<RoleBasedPermission> refresh() {
        List<RoleBasedPermission> permissions =  this.findAllRoleBasedPermissions();
        if (permissions == null) {
            return null;
        }

        roleBasedPermissionRepository.save(permissions);
        return permissions;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean delete(Long id) {
        if (id == null) {
            throw new BusinessException("id不能为空");
        }

        SystemPermissionModel permission = systemPermissionMapper.selectOneById(id);
        if (permission == null) {
            throw new BusinessException("权限项不存在");
        }

        systemPermissionMapper.deleteById(id);
        return true;
    }

    private List<SystemPermissionDto> convertToDTOs(List<SystemPermissionModel> models) {
        List<SystemPermissionDto> dtoList = new ArrayList<SystemPermissionDto>();
        if (CollectionUtils.isEmpty(models)) {
            return dtoList;
        }

        Set<String> allRoleCodes = new HashSet<String>();
        for (SystemPermissionModel model : models) {
            String[] roleCodes = TextUtil.splitByComma(model.getRoles());
            allRoleCodes.addAll(Arrays.asList(roleCodes));
        }

        Map<String, String> roleCodeNameMap = new HashMap<String, String>();
        List<SystemRoleModel> roles = systemRoleMapper.selectAllByRoleCodes(allRoleCodes);
        if (!CollectionUtils.isEmpty(roles)) {
            for (SystemRoleModel role : roles) {
                roleCodeNameMap.put(role.getRoleCode(), role.getRoleName());
            }
        }

        for (SystemPermissionModel model : models) {
            SystemPermissionDto dto = new SystemPermissionDto();
            dto.setId(model.getId());
            dto.setUrl(model.getUrl());

            List<String> roleCodes = new ArrayList<String>();
            List<String> roleNames = new ArrayList<String>();
            String[] roleCodeArr = TextUtil.splitByComma(model.getRoles());
            for (String roleCode : roleCodeArr) {
                roleCodes.add(roleCode);
                roleNames.add(roleCodeNameMap.get(roleCode));
            }
            dto.setRoleCodes(roleCodes);
            dto.setRoleNames(roleNames);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
