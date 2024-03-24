package com.alyas20.projectbased.core.security.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public interface TranslatorService {
    String toLocale(String msgCode);
}
