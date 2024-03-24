package com.alyas20.projectbased.core.security.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);

    UserDetails extractUserDetails(String token);

    String extractTokenByRequest(HttpServletRequest request);

    String extractTokenId(String token);
}