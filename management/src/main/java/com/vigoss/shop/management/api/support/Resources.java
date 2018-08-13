package com.vigoss.shop.management.api.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

@Component
public final class Resources {

    private static final Logger logger = LoggerFactory.getLogger(Resources.class);

    private static final Map<String, ResourceBundle> MESSAGES = new HashMap<String, ResourceBundle>();

    private static final String BUNDLEPOSITION = "i18n/messages";

    private static final String CODE_PREFIX = "CODE.";

    /**
     * 国际化信息
     */
    public static String getMessage(String key, Object... params) {
        ResourceBundle message = init();
        if (params != null && params.length > 0) {
            return String.format(message.getString(key), params);
        }
        return message.getString(key);
    }

    public static ResourceBundle init() {
        Locale locale = LocaleContextHolder.getLocale();
        ResourceBundle message = MESSAGES.get(locale.getLanguage());
        if (message == null) {
            logger.info("init i18n messages......");
            synchronized (MESSAGES) {
                message = MESSAGES.get(locale.getLanguage());
                if (message == null) {
                    message = ResourceBundle.getBundle(BUNDLEPOSITION, locale);
                    MESSAGES.put(locale.getLanguage(), message);
                }
            }
        }
        return message;
    }

    public static String getCodeMessage(Integer key) {
        return getMessage(CODE_PREFIX + key);
    }

    /**
     * 清除国际化信息
     */
    public static void flushMessage() {
        MESSAGES.clear();
    }
}
