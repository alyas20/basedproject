package com.alyas20.projectbased.core.repository;

import com.alyas20.projectbased.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    @Override
    <S extends User> S save(S entity);

    @Override
    Optional<User> findById(String s);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);
}
