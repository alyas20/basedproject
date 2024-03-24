package com.alyas20.projectbased.core.service;

import com.alyas20.projectbased.core.security.bean.UserBean;

public interface UserService {

    UserBean signUpProcess(UserBean userBean);
    String getEmail(String userId);
    UserBean getUserByUserName(String username);
}
