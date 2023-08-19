package com.alyas20.projectbased.service;

import com.alyas20.projectbased.entity.USER01;
import com.alyas20.projectbased.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        USER01 user01 = userRepository.findByUserName(username);

        if (user01 == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user01.getUserName())
                .password(user01.getUserPassword())
                .roles("USER") // You can add roles here if needed
                .build();
    }
}
