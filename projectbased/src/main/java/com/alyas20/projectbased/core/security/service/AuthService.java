package com.alyas20.projectbased.core.security.service;

import com.alyas20.projectbased.core.security.bean.LoginBean;
import com.alyas20.projectbased.core.security.bean.LogoutBean;
import com.alyas20.projectbased.core.security.bean.RefreshTokenBean;

public interface AuthService {

    public LoginBean login(LoginBean loginBean);
    public LogoutBean logout(LogoutBean logoutBean);

    public RefreshTokenBean refreshToken (RefreshTokenBean refreshTokenBean);
}
