package com.alyas20.projectbased.core.security.service;

import com.alyas20.projectbased.core.entity.User;

public interface UserSecurityService {
    User getUserByUsername(String username);

    String getSaltKeyById(String username);
}
