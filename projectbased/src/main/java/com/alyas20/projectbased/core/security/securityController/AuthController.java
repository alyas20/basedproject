package com.alyas20.projectbased.core.security.securityController;

import com.alyas20.projectbased.core.security.dto.AuthDTO;
import com.alyas20.projectbased.core.security.service.AuthService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);


    private final MessageSource messageSource;
    private final AuthenticationManager authenticationManager;
    private final AuthService authService;
    @Autowired
    public AuthController(AuthService authService, AuthenticationManager authenticationManager, MessageSource messageSource) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.messageSource = messageSource;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDTO.LoginResponse> login(@RequestBody AuthDTO.LoginRequest userLogin) {
        Authentication earlyAuth = new UsernamePasswordAuthenticationToken(userLogin.username(), userLogin.password());
        SecurityContextHolder.getContext().setAuthentication(earlyAuth);
        Authentication authentication =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(
                                userLogin.username(),
                                userLogin.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        log.debug("Token requested for user :{}", authentication.getAuthorities());
        String token = authService.generateToken(authentication);

        AuthDTO.LoginResponse response = new AuthDTO.LoginResponse(messageSource.getMessage("login.success", null, null), token);

        return ResponseEntity.ok(response);
    }
}