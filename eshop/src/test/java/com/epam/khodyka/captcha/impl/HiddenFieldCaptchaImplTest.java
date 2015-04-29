package com.epam.khodyka.captcha.impl;

import com.epam.khodyka.bean.Captcha;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andrii_Khodyka on 4/29/2015.
 */
public class HiddenFieldCaptchaImplTest {
    private static HiddenFieldCaptchaImpl fieldCaptcha;

    private static HttpServletRequest request;

    private static HttpServletResponse response;

    @BeforeClass
    public static void setUp(){
        fieldCaptcha = new HiddenFieldCaptchaImpl(5);
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
    }

    @Test
    public void test(){
        Captcha captcha = new Captcha(1, "Token", 5);
        Mockito.when(request.getParameter("hiddenCaptchaId")).thenReturn("123");
        fieldCaptcha.saveCaptcha(captcha, request, response);
        assertEquals("123", String.valueOf(captcha.getId()));
    }
}