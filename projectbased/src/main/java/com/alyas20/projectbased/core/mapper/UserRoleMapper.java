package com.alyas20.projectbased.core.mapper;

import com.alyas20.projectbased.core.security.bean.UserRoleBean;
import com.alyas20.projectbased.core.security.entity.UserRole;

public class UserRoleMapper {
    private UserRoleMapper() {
        throw new IllegalStateException("Utility class");
    }
    public static UserRoleBean mapEntityToBean(UserRole userRole) {
        UserRoleBean userRoleBean = new UserRoleBean();
        userRoleBean.setRoleCode(userRole.getRoleCode());
        userRoleBean.setRoleDesc(userRole.getRoleDesc());
        return userRoleBean;
    }
}
