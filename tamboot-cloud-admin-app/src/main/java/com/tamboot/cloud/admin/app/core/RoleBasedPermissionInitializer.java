package com.tamboot.cloud.admin.app.core;

import com.tamboot.cloud.admin.app.api.AppSystemSvcApi;
import com.tamboot.security.permission.RoleBasedPermission;
import com.tamboot.security.permission.RoleBasedPermissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import java.util.List;

public class RoleBasedPermissionInitializer implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger logger = LoggerFactory.getLogger(RoleBasedPermissionInitializer.class);
    
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        AppSystemSvcApi systemSvcApi = CloudAppContextHolder.get().getBean(AppSystemSvcApi.class);
        List<RoleBasedPermission> permissionList = systemSvcApi.findAllRoleBasedPermissions().getData();
        if (permissionList == null) {
            logger.info("permission list is null");
            return;
        }

        logger.info("permission list size is {}", permissionList.size());
        RoleBasedPermissionRepository permissionRepository = CloudAppContextHolder.get().getBean(RoleBasedPermissionRepository.class);
        permissionRepository.save(permissionList);
    }
}
