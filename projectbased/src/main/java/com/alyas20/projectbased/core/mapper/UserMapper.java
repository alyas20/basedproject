package com.alyas20.projectbased.core.mapper;

import com.alyas20.projectbased.core.bean.UserBean;
import com.alyas20.projectbased.core.entity.User;

public class UserMapper {
    public static UserBean mapEntityToBean(User user) {
        UserBean userBean = new UserBean();
        userBean.setUserId(user.getUserId());
        userBean.setUsername(user.getUsername());
        userBean.setUserEmail(user.getUserEmail());
        if (user.getRole() != null) {
            userBean.setRole(UserRoleMapper.mapEntityToBean(user.getRole()));
        }
        return userBean;
    }
}
