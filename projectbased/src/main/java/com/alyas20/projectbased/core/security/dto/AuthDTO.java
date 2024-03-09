package com.alyas20.projectbased.core.security.dto;

public class AuthDTO {
    public record LoginRequest(String username, String password) {
    }

    public record LoginResponse(String message) {
    }

    public record RefreshTokenResponse(String message) {
    }
}