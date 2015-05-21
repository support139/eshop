package com.epam.khodyka.servlet;

import com.epam.khodyka.Path;
import com.epam.khodyka.bean.*;
import com.epam.khodyka.db.entiry.Guitar;
import com.epam.khodyka.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrii_Khodyka on 5/21/2015.
 */
@WebServlet("/SubmitOrder")
public class SubmitOrderServlet extends HttpServlet {

    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.orderService = (OrderService) getServletContext().getAttribute("OrderService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Basket basket = (Basket) session.getAttribute("basket");

        List<OrderItem> orderItems = new ArrayList<>();
        for (Map.Entry<Guitar, Integer> entry : basket.getBasket().entrySet()) {
            Guitar guitar = entry.getKey();
            int amount = entry.getValue();
            double price = amount * guitar.getPrice();
            OrderItem orderItem = new OrderItem(guitar, amount, price);
            orderItems.add(orderItem);
        }

        ShopperBean shopperBean = (ShopperBean) session.getAttribute("shopper");
        Order order = new Order();
        order.setShopperBean(shopperBean);
        order.setStatus(OrderStatus.ADOPTED);
        order.setOrderDate(new Date());
        order.setStatusDetail("Order adopted");
        order.setItemList(orderItems);

        orderService.addNewOrder(order);
        basket.clearBasket();
        req.getRequestDispatcher(Path.SHOP_PAGE).forward(req, resp);
    }
}
