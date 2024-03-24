package com.alyas20.projectbased.core.security.bean;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;

@Data
@AllArgsConstructor
public class RefreshTokenBean {
    private HttpServletRequest request;
    private HttpHeaders headers;
    private String message;
    private String messageCode;
}
