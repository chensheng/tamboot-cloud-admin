package com.tamboot.cloud.admin.manageapp.system.service.impl;

import com.github.pagehelper.Page;
import com.tamboot.cloud.admin.manageapp.constants.UserStatus;
import com.tamboot.cloud.admin.manageapp.system.condition.PageUserCondition;
import com.tamboot.cloud.admin.manageapp.system.dto.SystemUserDto;
import com.tamboot.cloud.admin.manageapp.system.form.AssignRolesForm;
import com.tamboot.cloud.admin.manageapp.system.form.CreateUserForm;
import com.tamboot.cloud.admin.manageapp.system.form.PageUserForm;
import com.tamboot.cloud.admin.manageapp.system.form.ResetPasswordForm;
import com.tamboot.cloud.admin.manageapp.system.mapper.SystemRoleMapper;
import com.tamboot.cloud.admin.manageapp.system.mapper.SystemUserMapper;
import com.tamboot.cloud.admin.manageapp.system.mapper.SystemUserRoleMapper;
import com.tamboot.cloud.admin.manageapp.system.model.SystemRoleModel;
import com.tamboot.cloud.admin.manageapp.system.model.SystemUserModel;
import com.tamboot.cloud.admin.manageapp.system.model.SystemUserRoleModel;
import com.tamboot.cloud.admin.manageapp.system.service.SystemUserService;
import com.tamboot.common.tools.text.TextUtil;
import com.tamboot.security.core.PasswordEncoderFactory;
import com.tamboot.web.core.BusinessException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;

@Service
@Transactional(readOnly = true)
public class SystemUserServiceImpl implements SystemUserService {
    @Autowired
    private SystemUserMapper systemUserMapper;

    @Autowired
    private SystemRoleMapper systemRoleMapper;

    @Autowired
    private SystemUserRoleMapper systemUserRoleMapper;

    @Autowired
    private PasswordEncoderFactory passwordEncoderFactory;

    @Override
    @Transactional(readOnly = false)
    public boolean resetPassword(ResetPasswordForm form) {
        SystemUserModel user = systemUserMapper.selectOneById(form.getUserId());
        if (user == null) {
            throw new BusinessException("用户不存在");
        }

        String encodedPassword = passwordEncoderFactory.get().encode(form.getPassword());
        user.setPassword(encodedPassword);
        systemUserMapper.updateById(user);
        return true;
    }

    @Override
    public Page<SystemUserDto> pageDto(PageUserForm form) {
        PageUserCondition condition = new PageUserCondition();
        BeanUtils.copyProperties(form, condition);
        Page<SystemUserDto> dtoPage = systemUserMapper.pageDtoByCondition(form.getPageNum(), form.getPageSize(), condition);
        if (!CollectionUtils.isEmpty(dtoPage.getResult())) {
            for (SystemUserDto userDto : dtoPage.getResult()) {
                String[] roleCodeArr = TextUtil.splitByComma(userDto.getRoleCodes());
                String[] roleNameArr = TextUtil.splitByComma(userDto.getRoleNames());
                if (roleCodeArr != null) {
                    userDto.setRoleCodeList(Arrays.asList(roleCodeArr));
                } else {
                    userDto.setRoleCodeList(new ArrayList<String>(0));
                }
                if (roleNameArr != null) {
                    userDto.setRoleNameList(Arrays.asList(roleNameArr));
                } else {
                    userDto.setRoleNameList(new ArrayList<String>(0));
                }
            }
        }
        return dtoPage;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean enable(Long userId) {
        if (userId == null) {
            throw new BusinessException("请选择用户");
        }

        SystemUserModel user = systemUserMapper.selectOneById(userId);
        if (user == null) {
            throw new BusinessException("用户不存在");
        }

        if (UserStatus.ENABLED.getCode().equals(user.getStatus())) {
            throw new BusinessException("用户已经启用过");
        }

        user.setStatus(UserStatus.ENABLED.getCode());
        systemUserMapper.updateById(user);
        return true;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean disable(Long userId) {
        if (userId == null) {
            throw new BusinessException("请选择用户");
        }

        SystemUserModel user = systemUserMapper.selectOneById(userId);
        if (user == null) {
            throw new BusinessException("用户不存在");
        }

        if (UserStatus.DISABLED.getCode().equals(user.getStatus())) {
            throw new BusinessException("用户已经停用过");
        }

        user.setStatus(UserStatus.DISABLED.getCode());
        systemUserMapper.updateById(user);
        return true;
    }

    @Override
    @Transactional(readOnly = false)
    public SystemUserModel create(CreateUserForm form) {
        SystemUserModel existingUser = systemUserMapper.selectOneByUsername(form.getUsername());
        if (existingUser != null) {
            throw new BusinessException("用户名已存在");
        }

        String encodedPassword = passwordEncoderFactory.get().encode(form.getPassword());

        SystemUserModel user = new SystemUserModel();
        user.setUsername(form.getUsername());
        user.setPassword(encodedPassword);
        user.setStatus(UserStatus.ENABLED.getCode());
        systemUserMapper.insert(user);
        user.setPassword(null);
        return user;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean assignRoles(AssignRolesForm form) {
        SystemUserModel user = systemUserMapper.selectOneById(form.getUserId());
        if (user == null) {
            throw new BusinessException("用户不存在");
        }

        systemUserRoleMapper.deleteByUserId(user.getId());
        for (String roleCode : form.getRoleCodes()) {
            SystemRoleModel role = systemRoleMapper.selectOneByRoleCode(roleCode);
            if (role == null) {
                throw new BusinessException("角色编码" + roleCode + "不存在");
            }

            SystemUserRoleModel userRole = new SystemUserRoleModel();
            userRole.setUserId(form.getUserId());
            userRole.setRoleCode(roleCode);
            systemUserRoleMapper.insert(userRole);
        }
        return true;
    }

}
