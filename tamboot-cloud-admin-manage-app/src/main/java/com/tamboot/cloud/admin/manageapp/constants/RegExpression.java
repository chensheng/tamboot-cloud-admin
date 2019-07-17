package com.tamboot.cloud.admin.manageapp.constants;

public class RegExpression {
    public static final String PASSWORD = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$";

    public static final String ROLE_CODE = "[A-Z_]+";
}
