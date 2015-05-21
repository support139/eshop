package com.epam.khodyka.localization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by Andrii_Khodyka on 5/25/2015.
 */
public class SessionLocaleContainer extends LocaleContainer {

    @Override
    public Locale getLocale(HttpServletRequest request) {
        return (Locale) request.getSession().getAttribute("Locale");
    }

    @Override
    public void saveLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        request.getSession().setAttribute("Locale", locale);
    }
}
