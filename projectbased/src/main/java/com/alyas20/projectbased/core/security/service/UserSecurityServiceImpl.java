package com.alyas20.projectbased.core.security.service;

import com.alyas20.projectbased.core.security.entity.AuthUser;
import com.alyas20.projectbased.core.security.exception.UserNotFoundException;
import com.alyas20.projectbased.core.security.entity.User;
import com.alyas20.projectbased.core.security.repository.UserSecurityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSecurityServiceImpl implements UserSecurityService , UserDetailsService {

    /**
     * (2024-02-17, Alyas):- Note: In this clas better using UserNotFoundException and not other Exception for better debugging.
     **/

    private final UserSecurityRepository userSecurityRepository;

    @Override
    public User getUserByUsername(String username) {
        return userSecurityRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
    }

    @Override
    public String getSaltKeyById(String username) {
        Optional<User> userOptional = userSecurityRepository.findById(username);
        return userOptional.map(User::getUserSaltKey).orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userSecurityRepository
                .findByUsername(username)
                .map(AuthUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User name not found: " + username));
    }
}
