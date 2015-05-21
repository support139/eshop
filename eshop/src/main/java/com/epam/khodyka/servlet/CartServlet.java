package com.epam.khodyka.servlet;

import com.epam.khodyka.Path;
import com.epam.khodyka.bean.Basket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Andrii_Khodyka on 5/19/2015.
 */
@WebServlet("/Cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        double total = basket.getTotalPrice();
        int quantity = basket.getQuantity();

        session.setAttribute("quantity", quantity);
        session.setAttribute("totalPrice", total);
        req.getRequestDispatcher(Path.CART_PAGE).forward(req, resp);
    }
}
