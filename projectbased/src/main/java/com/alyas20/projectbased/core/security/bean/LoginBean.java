package com.alyas20.projectbased.core.security.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;

@Data
@AllArgsConstructor
public class LoginBean {
    private String username;
    private String password;
    private HttpHeaders headers;
}
