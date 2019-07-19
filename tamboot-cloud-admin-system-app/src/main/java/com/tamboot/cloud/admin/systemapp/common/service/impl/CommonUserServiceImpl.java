package com.tamboot.cloud.admin.systemapp.common.service.impl;

import com.tamboot.cloud.admin.systemapp.common.form.UpdatePasswordForm;
import com.tamboot.cloud.admin.systemapp.common.service.CommonUserService;
import com.tamboot.cloud.admin.systemapp.system.mapper.SystemUserMapper;
import com.tamboot.cloud.admin.systemapp.system.model.SystemUserModel;
import com.tamboot.security.core.PasswordEncoderFactory;
import com.tamboot.security.core.TambootAuthenticationService;
import com.tamboot.security.core.TambootUserDetails;
import com.tamboot.security.util.SafeSecurityContextHolder;
import com.tamboot.web.core.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@Transactional(readOnly = true)
public class CommonUserServiceImpl implements CommonUserService {
    @Autowired
    private PasswordEncoderFactory passwordEncoderFactory;

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Autowired
    private TambootAuthenticationService tambootAuthenticationService;

    @Override
    public TambootUserDetails details() {
        return SafeSecurityContextHolder.getUserDetails();
    }

    @Override
    public void refreshToken(HttpServletRequest request) {
        tambootAuthenticationService.refreshToken(request);
    }

    @Override
    @Transactional(readOnly = false)
    public boolean updatePassword(UpdatePasswordForm form) {
        Long userId = SafeSecurityContextHolder.getUserId();
        SystemUserModel user = systemUserMapper.selectOneById(userId);

        if (!passwordEncoderFactory.get().matches(form.getOldPassword(), user.getPassword())) {
            throw new BusinessException("原密码错误");
        }

        user.setPassword(passwordEncoderFactory.get().encode(form.getNewPassword()));
        systemUserMapper.updateById(user);
        return true;
    }
}
