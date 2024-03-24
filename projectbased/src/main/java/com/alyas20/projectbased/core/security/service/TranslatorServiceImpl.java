package com.alyas20.projectbased.core.security.service;

import com.alyas20.projectbased.core.security.config.LocaleResolver;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Locale;

@Component
public class TranslatorServiceImpl implements TranslatorService {
    private static final Logger log = LoggerFactory.getLogger(TranslatorServiceImpl.class);

    private static ResourceBundleMessageSource messageSource;
    private static LocaleResolver localeResolver;

    @Autowired
    TranslatorServiceImpl(ResourceBundleMessageSource messageSource, LocaleResolver localeResolver) {
        this.messageSource = messageSource;
        this.localeResolver = localeResolver;
    }

    @Override
    public String toLocale(String msgCode) {
//        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        HttpServletRequest request = attr.getRequest();
//        String username = request.getParameter("username");
        Locale locale = LocaleContextHolder.getLocale();
//        log.info("username: "+ username);
        log.info("Locale: "+ locale);
//        return this.messageSource.getMessage(msgCode, null, localeResolver.resolveLocale(request));
        return this.messageSource.getMessage(msgCode, null, locale);
    }
}
