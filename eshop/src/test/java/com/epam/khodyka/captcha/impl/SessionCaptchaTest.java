package com.epam.khodyka.captcha.impl;

import com.epam.khodyka.bean.Captcha;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SessionCaptchaTest {

    private static HttpServletRequest request;
    private static HttpServletResponse response;

    private static HttpSession session;

    private static SessionCapthaImpl sessionCaptha;


    @BeforeClass
    public static void setup() throws ServletException, IOException {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        sessionCaptha = new SessionCapthaImpl(5);
        Mockito.when(request.getSession()).thenReturn(session);
    }

    @Test
    public void sessionShouldContainCaptchaWhenSessionCaptchaModeInUse()
            throws ServletException, IOException {
        Captcha captcha = new Captcha(1, "Token", 5);
        ArgumentCaptor<HttpSession> argumentCaptor = ArgumentCaptor.forClass(HttpSession.class);
        sessionCaptha.saveCaptcha(captcha, request, response);
        Mockito.verify(session).setAttribute(Mockito.eq("captcha"), argumentCaptor.capture());
        assertEquals(argumentCaptor.getValue(), captcha);
    }
}
