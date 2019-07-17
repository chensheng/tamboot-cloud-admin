package com.tamboot.cloud.admin.manageapp.api;

import com.tamboot.cloud.admin.manageapp.api.response.MenuTree;
import com.tamboot.common.web.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(contextId = "systemSvcMenuApi", name = "system-svc")
public interface SystemSvcMenuApi {

    @GetMapping("/menu/treeForUser")
    ApiResponse<List<MenuTree>> treeForUser(@RequestParam("userId") Long userId);
}
