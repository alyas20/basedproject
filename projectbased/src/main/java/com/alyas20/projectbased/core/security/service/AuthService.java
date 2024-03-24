package com.alyas20.projectbased.core.security.service;

import com.alyas20.projectbased.core.security.bean.LoginBean;
import com.alyas20.projectbased.core.security.bean.LogoutBean;
import com.alyas20.projectbased.core.security.bean.RefreshTokenBean;

public interface AuthService {

    LoginBean login(LoginBean loginBean);
    LogoutBean logout(LogoutBean logoutBean);

    RefreshTokenBean refreshToken (RefreshTokenBean refreshTokenBean);
}
