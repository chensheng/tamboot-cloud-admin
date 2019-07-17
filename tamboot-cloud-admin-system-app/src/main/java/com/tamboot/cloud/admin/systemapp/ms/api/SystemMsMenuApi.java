package com.tamboot.cloud.admin.systemapp.ms.api;

import com.tamboot.cloud.admin.systemapp.ms.response.MenuTree;
import com.tamboot.common.web.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(contextId = "systemMsMenuApi", name = "system-ms")
public interface SystemMsMenuApi {

    @GetMapping("/menu/treeForUser")
    ApiResponse<List<MenuTree>> treeForUser(@RequestParam("userId") Long userId);
}
