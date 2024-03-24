package com.alyas20.projectbased.core.security.securityController;

import com.alyas20.projectbased.core.security.bean.LoginBean;
import com.alyas20.projectbased.core.security.bean.LogoutBean;
import com.alyas20.projectbased.core.security.bean.RefreshTokenBean;
import com.alyas20.projectbased.core.security.dto.AuthDTO;
import com.alyas20.projectbased.core.security.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;
    private final TranslatorService translatorService;

    @Autowired
    public AuthController(AuthService authService, TranslatorService translatorService) {
        this.authService = authService;
        this.translatorService = translatorService;

    }

    @PostMapping("/login")
    public ResponseEntity<AuthDTO.LoginResponse> login(@RequestBody AuthDTO.LoginRequest userLogin) {
        LoginBean loginBean = new LoginBean(userLogin.username(), userLogin.password(), null);
        loginBean = authService.login(loginBean);
        AuthDTO.LoginResponse response = new AuthDTO.LoginResponse(translatorService.toLocale("login.success"));
        return ResponseEntity.ok().headers(loginBean.getHeaders()).body(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<AuthDTO.LogoutResponse> logout(HttpServletRequest request) {
        LogoutBean logoutBean = new LogoutBean(request, null, null);
        logoutBean = authService.logout(logoutBean);
        AuthDTO.LogoutResponse response = new AuthDTO.LogoutResponse(logoutBean.getMessage());
        return logoutBean.getMessageCode().equals("logout.success") ? ResponseEntity.ok().body(response) :
                ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthDTO.RefreshTokenResponse> refreshToken(HttpServletRequest request) {
        RefreshTokenBean refreshTokenBean = new RefreshTokenBean(request, null, null, null);
        refreshTokenBean = authService.refreshToken(refreshTokenBean);
        AuthDTO.RefreshTokenResponse refreshTokenResponse = new AuthDTO.RefreshTokenResponse(refreshTokenBean.getMessage());
        return refreshTokenBean.getMessageCode().equals("refresh.success") ? ResponseEntity.ok().headers(refreshTokenBean.getHeaders()).body(refreshTokenResponse) :
                ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(refreshTokenResponse);
    }

}