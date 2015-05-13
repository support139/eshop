package com.epam.khodyka.requestextractor.impl;

import com.epam.khodyka.bean.SignupForm;
import com.epam.khodyka.db.Fields;
import com.epam.khodyka.requestextractor.Extractor;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gofmiller on 19.05.2015.
 */
public class SignupFormExtractor implements Extractor<SignupForm> {

    @Override
    public SignupForm extract(HttpServletRequest req) {
        SignupForm formBean = new SignupForm();
        formBean.setLogin(req.getParameter(Fields.USER_LOGIN));
        formBean.setPassword(req.getParameter(Fields.USER_PASSWORD));
        formBean.setName(req.getParameter(Fields.USER_NAME));
        formBean.setSurname(req.getParameter(Fields.USER_SURNAME));
        formBean.setEmail(req.getParameter(Fields.USER_EMAIL));
        return formBean;
    }
}
