package com.alyas20.projectbased.core.security.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class TranslatorServiceImpl implements TranslatorService {
    private static final Logger log = LoggerFactory.getLogger(TranslatorServiceImpl.class);

    private final ResourceBundleMessageSource messageSource;

    @Override
    public String toLocale(String msgCode) {
        Locale locale = LocaleContextHolder.getLocale();
        log.debug("Locale  {} :", locale);
        return messageSource.getMessage(msgCode, null, locale);
    }
}
