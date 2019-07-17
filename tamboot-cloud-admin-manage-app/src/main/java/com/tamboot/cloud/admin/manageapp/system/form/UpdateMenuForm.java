package com.tamboot.cloud.admin.manageapp.system.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateMenuForm {
    @NotNull(message = "请选择菜单")
    private Long id;

    @NotEmpty(message = "请输入名称")
    private String name;

    @NotEmpty(message = "请输入地址")
    private String path;

    private String locale;

    private String icon;

    private Integer orderIndex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }
}
