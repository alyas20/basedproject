package com.alyas20.projectbased.core.dto;

import com.alyas20.projectbased.core.bean.UserBean;
import com.alyas20.projectbased.core.entity.User;

public class DashboardDTO {
    public record dashboardMainRequest(String username){
    }
    public record dashboardMainResponse(UserBean user){
    }
}
