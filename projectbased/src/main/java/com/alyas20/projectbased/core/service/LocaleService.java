package com.alyas20.projectbased.core.service;

import com.alyas20.projectbased.core.security.entity.Locale;

public interface LocaleService {

    Locale getLocaleByCode(String localeCode);
}
