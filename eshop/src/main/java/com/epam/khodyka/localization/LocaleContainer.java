package com.epam.khodyka.localization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by Andrii_Khodyka on 5/25/2015.
 */
public abstract class LocaleContainer {



    public abstract Locale getLocale(HttpServletRequest request);

    public abstract void saveLocale(HttpServletRequest request, HttpServletResponse response, Locale locale);


}
