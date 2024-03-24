package com.alyas20.projectbased.core.security.service;

public interface TokenBlacklistService {
    void invalidateToken(String userName, String tokenId);

    boolean isTokenInvalid(String userName, String tokenId);
}
