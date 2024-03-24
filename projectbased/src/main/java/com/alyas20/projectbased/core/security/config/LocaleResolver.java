package com.alyas20.projectbased.core.security.config;

import com.alyas20.projectbased.core.security.service.JwtServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Component
public class LocaleResolver extends AcceptHeaderLocaleResolver{
    private static final Logger log = LoggerFactory.getLogger(LocaleResolver.class);
    List<Locale> LOCALES = Arrays.asList(
            new Locale("en"),
            new Locale("fr"),
            new Locale("my")
            );

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getHeader("Accept-Language");
        log.info("lang : :> : " + lang);
        if (lang == null || lang.isEmpty()) {
            return Locale.getDefault();
        }
        List<Locale.LanguageRange> list = Locale.LanguageRange.parse(lang);
        Locale locale = Locale.lookup(list, LOCALES);
        return locale;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
        rs.setBasename("messages");
        rs.setDefaultEncoding("UTF-8");
        rs.setDefaultLocale(LOCALES.get(1));
        rs.setUseCodeAsDefaultMessage(true);
        return rs;
    }
}
