package com.epam.khodyka.servlet;

import com.epam.khodyka.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrii_Khodyka on 5/20/2015.
 */

@WebServlet("/NewOrder")
public class NewOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Path.NEW_ORDER_PAGE).forward(req, resp);
    }
}
