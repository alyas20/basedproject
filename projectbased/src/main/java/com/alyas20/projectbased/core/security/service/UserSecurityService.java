package com.alyas20.projectbased.core.security.service;

import com.alyas20.projectbased.core.security.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserSecurityService {
    User getUserByUsername(String username);

    String getSaltKeyById(String username);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
