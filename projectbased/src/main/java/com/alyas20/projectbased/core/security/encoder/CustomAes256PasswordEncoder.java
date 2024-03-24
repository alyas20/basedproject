package com.alyas20.projectbased.core.security.encoder;


import com.alyas20.projectbased.core.security.entity.User;
import com.alyas20.projectbased.core.security.service.UserSecurityService;
import com.alyas20.projectbased.core.security.securityUtil.encryption.AES256Encryption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAes256PasswordEncoder implements PasswordEncoder {
    private static final Logger log = LoggerFactory.getLogger(CustomAes256PasswordEncoder.class);

    @Autowired
    private UserSecurityService userSecurityService;


    @Override
    public String encode(CharSequence rawPassword) {
        log.debug("Current :-:: >  : encode");
        //TODO: Encode the password here
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        log.debug("Current :-:: >  : matches");
        log.debug("rawPassword: {}", rawPassword);
        log.debug("encodedPassword: {}", encodedPassword);
        String username = getCurrentUsername();
        log.debug("username: {}", username);
        User user = userSecurityService.getUserByUsername(username);
        try {
            String newEncryptPassword = AES256Encryption.encrypt(rawPassword.toString(), user.getUserSaltKey());
            return newEncryptPassword.equals(user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getCurrentUsername() {
        log.debug("Current :-:: >  : getCurrentUsername");
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

}