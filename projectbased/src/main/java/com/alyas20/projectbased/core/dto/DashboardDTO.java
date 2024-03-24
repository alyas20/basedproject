package com.alyas20.projectbased.core.dto;

import com.alyas20.projectbased.core.security.bean.UserBean;

public class DashboardDTO {
    public record dashboardMainRequest(String username){
    }
    public record dashboardMainResponse(String message, UserBean user){
    }
}
