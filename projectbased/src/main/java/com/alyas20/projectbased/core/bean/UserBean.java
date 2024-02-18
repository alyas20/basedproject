package com.alyas20.projectbased.core.bean;

import com.alyas20.projectbased.core.entity.UserRole;
import lombok.Data;

@Data
public class UserBean {
    private Long userId;
    private String username;
    private String userSaltKey;
    private String userEmail;
    private String userPassword;
    private UserRole role;
    private String message;
}
