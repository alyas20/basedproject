package com.alyas20.projectbased.repository;

import com.alyas20.projectbased.entity.USER01;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

@Hidden
public interface UserRepository extends JpaRepository<USER01, Long> {

    USER01 findByUserName(String userName);
}
