package com.tamboot.cloud.admin.systemapp.system.form;

import javax.validation.constraints.NotEmpty;

public class CreateMenuForm {
    @NotEmpty(message = "请输入名称")
    private String name;

    @NotEmpty(message = "请输入地址")
    private String path;

    private String locale;

    private String icon;

    private Long parent;

    private Integer orderIndex;

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
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

    public String getName() {
        return name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }
}
