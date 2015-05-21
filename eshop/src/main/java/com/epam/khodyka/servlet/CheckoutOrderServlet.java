package com.epam.khodyka.servlet;

import com.epam.khodyka.Path;
import com.epam.khodyka.bean.ShopperBean;
import com.epam.khodyka.requestextractor.Extractor;
import com.epam.khodyka.requestextractor.impl.ShopperBeanExtractor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Andrii_Khodyka on 5/21/2015.
 */
@WebServlet("/CheckoutOrder")
public class CheckoutOrderServlet extends HttpServlet {

    private Extractor<ShopperBean> shopperBeanExtractor;

    @Override
    public void init() throws ServletException {
        super.init();
        this.shopperBeanExtractor = new ShopperBeanExtractor();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShopperBean shopperBean = shopperBeanExtractor.extract(req);
        HttpSession session = req.getSession();
        session.setAttribute("shopper", shopperBean);
        req.getRequestDispatcher(Path.CHECKOUT_ORDER_PAGE).forward(req, resp);
    }
}
