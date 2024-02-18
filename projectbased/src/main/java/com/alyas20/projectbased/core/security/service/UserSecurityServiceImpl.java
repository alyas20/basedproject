package com.alyas20.projectbased.core.security.service;

import com.alyas20.projectbased.core.security.exception.UserNotFoundException;
import com.alyas20.projectbased.core.entity.User;
import com.alyas20.projectbased.core.security.repository.UserSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {

    /**
     * (2024-02-17, Alyas):- Note: In this clas better using UserNotFoundException and not other Exception for better debugging.
     **/

    private final UserSecurityRepository userSecurityRepository;
    @Autowired
    public UserSecurityServiceImpl(UserSecurityRepository userSecurityRepository) {
        this.userSecurityRepository = userSecurityRepository;
    }

    @Override
    public User getUserByUsername(String username) {
        return userSecurityRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
    }

    @Override
    public String getSaltKeyById(String username) {
        Optional<User> userOptional = userSecurityRepository.findById(username);
        return userOptional.map(User::getUserSaltKey).orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
    }
}
