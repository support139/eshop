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
 * Created by Andrii_Khodyka on 5/20/2015.
 */
@WebServlet("/RemoveOrderItem")
public class RemoveOrderItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        int orderItemId = Integer.parseInt(req.getParameter("orderItemId"));

//        for (Map.Entry<Guitar, Integer> entry : basket.getBasket().entrySet()) {
//            if (entry.getKey().getId() == orderItemId) {
//                basket.remove(entry.getKey());
//            }
//        }
        basket.removeOrderItem(orderItemId);
        session.setAttribute("basket", basket);
    }
}
