package com.epam.khodyka.servlet;

import com.epam.khodyka.Path;
import com.epam.khodyka.bean.Basket;
import com.epam.khodyka.bean.LoginForm;
import com.epam.khodyka.db.Fields;
import com.epam.khodyka.db.entiry.User;
import com.epam.khodyka.requestextractor.Extractor;
import com.epam.khodyka.requestextractor.impl.LoginFormExtractor;
import com.epam.khodyka.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrii_Khodyka on 4/30/2015.
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    private UserService userService;
    private Extractor<LoginForm> loginFormExtractor;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userService = (UserService) getServletContext().getAttribute("UserService");
        this.loginFormExtractor = new LoginFormExtractor();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginForm loginForm = loginFormExtractor.extract(req);
        User user = userService.login(loginForm);
        if (user != null) {
            Basket basket = new Basket();
            req.getSession().setAttribute("basket", basket);
            req.getSession().setAttribute("quantity", basket.getQuantity());
            req.getSession().setAttribute("CURRENT_USER", user);
            resp.sendRedirect(Path.SHOP_SERVLET);
            return;
        }
        resp.sendRedirect(Path.LOGIN_PAGE);
    }
}
