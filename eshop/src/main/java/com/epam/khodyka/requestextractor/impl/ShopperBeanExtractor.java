package com.epam.khodyka.requestextractor.impl;

import com.epam.khodyka.bean.ShopperBean;
import com.epam.khodyka.requestextractor.Extractor;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Andrii_Khodyka on 5/21/2015.
 */
public class ShopperBeanExtractor implements Extractor<ShopperBean> {

    @Override
    public ShopperBean extract(HttpServletRequest req) {
        ShopperBean shopperBean = new ShopperBean();

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String mobilephone = req.getParameter("mobilephone");
        String country = req.getParameter("country");
        String state = req.getParameter("state");
        String adress = req.getParameter("adress");
        String zipcode = req.getParameter("zipcode");
        String payment = req.getParameter("payment");
        String cardId = req.getParameter("cardId");

        shopperBean.setFirstName(firstname);
        shopperBean.setLastName(lastname);
        shopperBean.setEmail(email);
        shopperBean.setMobilePhone(mobilephone);
        shopperBean.setCountry(country);
        shopperBean.setState(state);
        shopperBean.setAdress(adress);
        shopperBean.setZipCode(zipcode);
        shopperBean.setPayment(payment);
        shopperBean.setCardId(cardId);

        return shopperBean;
    }
}
