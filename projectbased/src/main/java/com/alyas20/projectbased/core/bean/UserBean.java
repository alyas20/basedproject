package com.alyas20.projectbased.core.bean;
import lombok.Data;

@Data
public class UserBean {
    private Long userId;
    private String username;
    private String userPassword;
    private String userEmail;
    private UserRoleBean role;
    private String message;
}
