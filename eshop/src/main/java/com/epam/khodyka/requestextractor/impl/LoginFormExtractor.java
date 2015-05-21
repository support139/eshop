package com.epam.khodyka.requestextractor.impl;

import com.epam.khodyka.bean.LoginForm;
import com.epam.khodyka.db.Fields;
import com.epam.khodyka.requestextractor.Extractor;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gofmiller on 19.05.2015.
 */
public class LoginFormExtractor implements Extractor<LoginForm> {

    @Override
    public LoginForm extract(HttpServletRequest req) {
        LoginForm loginForm = new LoginForm();
        loginForm.setLogin(req.getParameter(Fields.USER_LOGIN));
        loginForm.setPassword(req.getParameter(Fields.USER_PASSWORD));
        return loginForm;
    }
}
