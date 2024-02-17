package com.alyas20.projectbased.core.security.repository;

import com.alyas20.projectbased.core.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String userName);
}