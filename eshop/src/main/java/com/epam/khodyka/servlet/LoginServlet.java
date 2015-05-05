package com.epam.khodyka.servlet;

import com.epam.khodyka.bean.LoginForm;
import com.epam.khodyka.db.Fields;
import com.epam.khodyka.db.entiry.User;
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

    @Override
    public void init() throws ServletException {
        super.init();
        this.userService = (UserService) getServletContext().getAttribute("UserService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginForm loginForm = new LoginForm();
        loginForm.setLogin(req.getParameter(Fields.USER_LOGIN));
        loginForm.setPassword(req.getParameter(Fields.USER_PASSWORD));
        User user = userService.login(loginForm);
        if (user != null) {
            req.getSession().setAttribute("CURRENT_USER", user);
            resp.sendRedirect("login.jsp");
            return;
        }
        resp.sendRedirect("Signup");
    }
}
