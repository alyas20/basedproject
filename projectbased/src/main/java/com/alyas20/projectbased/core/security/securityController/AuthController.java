package com.alyas20.projectbased.core.security.securityController;

import com.alyas20.projectbased.core.security.dto.AuthDTO;
import com.alyas20.projectbased.core.security.service.JwtService;
import com.alyas20.projectbased.core.security.service.UserSecurityService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);


    private final MessageSource messageSource;
    private final AuthenticationManager authenticationManager;
    private final UserSecurityService userSecurityService;
    private final JwtService jwtService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, MessageSource messageSource,
                          UserSecurityService userSecurityService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.messageSource = messageSource;
        this.userSecurityService = userSecurityService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDTO.LoginResponse> login(@RequestBody AuthDTO.LoginRequest userLogin) {
        Authentication earlyAuth = new UsernamePasswordAuthenticationToken(userLogin.username(), userLogin.password());
        SecurityContextHolder.getContext().setAuthentication(earlyAuth);
        Authentication authentication =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(
                                userSecurityService.loadUserByUsername(userLogin.username()),
                                userLogin.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        log.debug("Token requested for user :{}", authentication.getAuthorities());
        String token = jwtService.generateToken((UserDetails) authentication.getPrincipal());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        AuthDTO.LoginResponse response = new AuthDTO.LoginResponse(messageSource.getMessage("login.success", null, null));

        return ResponseEntity.ok().headers(headers).body(response) ;
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthDTO.RefreshTokenResponse> refreshToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String expiredToken) {
        String token = extractToken(expiredToken);
        UserDetails userDetails = jwtService.extractUserDetails(token);
        String newToken = jwtService.generateToken(userDetails);
        AuthDTO.RefreshTokenResponse response = new AuthDTO.RefreshTokenResponse(newToken);
        return ResponseEntity.ok(response);
    }

    private String extractToken(String authorizationHeader) {
        return authorizationHeader.replace("Bearer ", "");
    }

}