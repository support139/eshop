package com.epam.khodyka.servlet;

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
@WebServlet("/ChangeQuantity")
public class ChangeQuantityServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Basket basket = (Basket) session.getAttribute("basket");

        int orderItemId = Integer.parseInt(req.getParameter("orderItemId"));
        int newQuantity = Integer.parseInt(req.getParameter("quantity"));

//        for (Map.Entry<Guitar, Integer> entry : basket.getBasket().entrySet()) {
//            if (entry.getKey().getId() == orderItemId) {
//                basket.getBasket().put(entry.getKey(), orderQuantity);
//            }
//        }
        basket.changeItemQuantity(orderItemId, newQuantity);
        session.setAttribute("basket", basket);
    }
}
