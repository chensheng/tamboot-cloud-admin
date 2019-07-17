package com.tamboot.cloud.admin.security.core;

import com.tamboot.cloud.admin.security.ms.api.SecuritySystemMsApi;
import com.tamboot.cloud.admin.security.ms.response.UserInfo;
import com.tamboot.common.web.RecordStatus;
import com.tamboot.security.core.TambootUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DatabaseUserDetailsService implements UserDetailsService {
    @Autowired
    private SecuritySystemMsApi systemMsApi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = systemMsApi.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("username not found");
        }

        boolean isUserDisabled = (user.getStatus() == null || user.getStatus().equals(RecordStatus.DISABLED));
        String[] roles = systemMsApi.findRolesForUser(user.getId());
        return TambootUserDetails
                .init(user.getId(), user.getUsername(), user.getPassword())
                .disabled(isUserDisabled)
                .roles(roles)
                .build();
    }
}
