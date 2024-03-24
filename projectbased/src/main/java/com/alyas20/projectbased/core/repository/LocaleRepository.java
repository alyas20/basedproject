package com.alyas20.projectbased.core.repository;

import com.alyas20.projectbased.core.security.entity.Locale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocaleRepository extends JpaRepository<Locale, String> {
    @Override
    <S extends Locale> S save(S entity);

    @Override
    Optional<Locale> findById(String s);

}
