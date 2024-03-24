package com.alyas20.projectbased.core.security.bean;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogoutBean {
    private HttpServletRequest request;
    private String message;
    private String messageCode;
}
