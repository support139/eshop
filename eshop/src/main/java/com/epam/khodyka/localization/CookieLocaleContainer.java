package com.epam.khodyka.localization;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by Andrii_Khodyka on 5/25/2015.
 */
public class CookieLocaleContainer extends LocaleContainer {

    @Override
    public Locale getLocale(HttpServletRequest request) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("Locale")) {
                return new Locale(cookie.getValue());
            }
        }
        return null;
    }

    @Override
    public void saveLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        Cookie cookie = new Cookie("Locale", locale.getCountry());
        response.addCookie(cookie);
    }
}
