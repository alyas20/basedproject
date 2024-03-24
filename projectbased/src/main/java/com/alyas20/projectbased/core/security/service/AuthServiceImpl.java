package com.alyas20.projectbased.core.security.service;

import com.alyas20.projectbased.core.security.bean.LoginBean;
import com.alyas20.projectbased.core.security.bean.LogoutBean;
import com.alyas20.projectbased.core.security.bean.RefreshTokenBean;
import com.alyas20.projectbased.core.security.dto.AuthDTO;
import com.alyas20.projectbased.core.security.securityController.AuthController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final MessageSource messageSource;
    private final AuthenticationManager authenticationManager;
    private final UserSecurityService userSecurityService;
    private final JwtService jwtService;
    private final TokenBlacklistService tokenBlacklistService;
    private final TranslatorService translatorService;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, MessageSource messageSource,
                          UserSecurityService userSecurityService, JwtService jwtService, TokenBlacklistService tokenBlacklistService,
                          TranslatorService translatorService) {
        this.authenticationManager = authenticationManager;
        this.messageSource = messageSource;
        this.userSecurityService = userSecurityService;
        this.jwtService = jwtService;
        this.tokenBlacklistService = tokenBlacklistService;
        this.translatorService = translatorService;

    }
    @Override
    public LoginBean login(LoginBean loginBean) {
        Authentication earlyAuth = new UsernamePasswordAuthenticationToken(loginBean.getUsername(), loginBean.getPassword());
        SecurityContextHolder.getContext().setAuthentication(earlyAuth);
        Authentication authentication =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(
                                userSecurityService.loadUserByUsername(loginBean.getUsername()),
                                loginBean.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String locale = userSecurityService.getUserByUsername(loginBean.getUsername()).getLocale().getLocaleCode();
        log.debug("Token requested for user :{}", authentication.getAuthorities());
        String token = jwtService.generateToken((UserDetails) authentication.getPrincipal());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        headers.add(HttpHeaders.ACCEPT_LANGUAGE, locale == null ? "en" : locale);
        loginBean.setHeaders(headers);
        return loginBean;
    }

    @Override
    public LogoutBean logout(LogoutBean logoutBean) {
        String token = jwtService.extractTokenByRequest(logoutBean.getRequest());
        String tokenId = jwtService.extractTokenId(token);
        String userName = jwtService.extractUserName(token);
        if (!tokenBlacklistService.isTokenInvalid(userName, tokenId)) {
            tokenBlacklistService.invalidateToken(userName, tokenId);
            SecurityContextHolder.clearContext();
            logoutBean.setMessageCode("logout.success");
            logoutBean.setMessage(translatorService.toLocale("refresh.success"));
            return logoutBean;
        }
        logoutBean.setMessageCode("logout.failed");
        logoutBean.setMessage(translatorService.toLocale("refresh.failed"));
        return logoutBean;
    }

    @Override
    public RefreshTokenBean refreshToken(RefreshTokenBean refreshTokenBean) {
        String token = jwtService.extractTokenByRequest(refreshTokenBean.getRequest());
        String tokenId = jwtService.extractTokenId(token);
        String userName = jwtService.extractUserName(token);
        if (!tokenBlacklistService.isTokenInvalid(userName, tokenId)) {
            UserDetails userDetails = jwtService.extractUserDetails(token);
            String newToken = jwtService.generateToken(userDetails);
            tokenBlacklistService.invalidateToken(userName,token);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + newToken);
            refreshTokenBean.setHeaders(headers);
            refreshTokenBean.setMessageCode("refresh.success");
            refreshTokenBean.setMessage(translatorService.toLocale("refresh.success"));
            return refreshTokenBean;
        }
        refreshTokenBean.setMessageCode("refresh.failed");
        refreshTokenBean.setMessage(translatorService.toLocale("refresh.failed"));
        return refreshTokenBean;
    }
}
