package com.tamboot.cloud.admin.systemms.service.impl;

import com.tamboot.cloud.admin.systemms.mapper.SystemUserMapper;
import com.tamboot.cloud.admin.systemms.model.SystemUserModel;
import com.tamboot.cloud.admin.systemms.service.SystemUserService;
import com.tamboot.common.tools.text.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SystemUserServiceImpl implements SystemUserService {
    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public SystemUserModel findByUsername(String username) {
        if (TextUtil.isEmpty(username)) {
            return null;
        }

        return systemUserMapper.selectOneByUsername(username);
    }

}
