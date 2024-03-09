package com.alyas20.projectbased.core.mapper;

import com.alyas20.projectbased.core.bean.UserRoleBean;
import com.alyas20.projectbased.core.entity.UserRole;

public class UserRoleMapper {
    public static UserRoleBean mapEntityToBean(UserRole userRole) {
        UserRoleBean userRoleBean = new UserRoleBean();
        userRoleBean.setRoleCode(userRole.getRoleCode());
        userRoleBean.setRoleDesc(userRole.getRoleDesc());
        return userRoleBean;
    }
}
