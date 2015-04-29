package com.epam.khodyka.captcha.impl;

import com.epam.khodyka.bean.Captcha;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.assertEquals;

public class CookieCaptchaTest {

    private static CookieCaptchaImpl captchaImpl;

    private static HttpServletRequest request;

    private static HttpServletResponse response;


    @BeforeClass
    public static void setUp() throws Exception {
        captchaImpl = new CookieCaptchaImpl(5);
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
    }

    @Test
    public void cookieShouldContainCaptchaIdWhenCookieModeInUse() {
        Captcha captcha = new Captcha(1, "Token", 5);
        ArgumentCaptor<Cookie> captor = ArgumentCaptor.forClass(Cookie.class);
        captchaImpl.saveCaptcha(captcha, request, response);
        Mockito.verify(response).addCookie(captor.capture());
        assertEquals(captor.getValue().getValue(), "1");
    }
}
