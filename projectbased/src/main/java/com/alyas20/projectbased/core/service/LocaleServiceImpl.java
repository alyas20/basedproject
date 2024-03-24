package com.alyas20.projectbased.core.service;

import com.alyas20.projectbased.core.repository.LocaleRepository;
import com.alyas20.projectbased.core.security.entity.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocaleServiceImpl implements LocaleService {

    private final LocaleRepository localeRepository;
    @Autowired
    public LocaleServiceImpl(LocaleRepository localeRepository ) {
        this.localeRepository = localeRepository;
    }
    @Override
    public Locale getLocaleByCode(String localeCode) {
        Locale defaultLocale = Locale.builder()
                .localeCode("en_US")
                .localeDesc("English (United States)")
                .build();
        return localeRepository.findById(localeCode).orElse(defaultLocale);
    }
}
