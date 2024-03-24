package com.alyas20.projectbased.core.mapper;

import com.alyas20.projectbased.core.security.bean.UserBean;
import com.alyas20.projectbased.core.security.entity.User;

public class UserMapper {
    private UserMapper() {
        throw new IllegalStateException("Utility class");
    }
    public static UserBean mapEntityToBean(User user) {
        UserBean userBean = new UserBean();
        userBean.setUserId(user.getUserId());
        userBean.setUsername(user.getUsername());
        userBean.setUserEmail(user.getUserEmail());
        if (user.getUserRole() != null) {
            userBean.setRole(UserRoleMapper.mapEntityToBean(user.getUserRole()));
        }
        return userBean;
    }
}
