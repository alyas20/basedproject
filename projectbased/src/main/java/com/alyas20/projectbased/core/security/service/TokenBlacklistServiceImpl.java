package com.alyas20.projectbased.core.security.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TokenBlacklistServiceImpl implements TokenBlacklistService {

    private Map<String,String> invalidatedTokens = new HashMap<>();

    @Override
    public synchronized void invalidateToken(String userName,String tokenId) {
        invalidatedTokens.put(userName,tokenId);
    }

    @Override
    public synchronized boolean isTokenInvalid(String userName, String tokenId) {
        String storedTokenId = invalidatedTokens.get(userName);
        return storedTokenId != null && storedTokenId.equals(tokenId);
    }
}