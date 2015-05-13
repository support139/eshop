package com.epam.khodyka.servlet;

import com.epam.khodyka.bean.Basket;
import com.epam.khodyka.bean.OrderItem;
import com.epam.khodyka.db.entiry.Guitar;
import com.epam.khodyka.service.ProductService;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Gofmiller on 17.05.2015.
 */
@WebServlet("/Buy")
public class BuyServlet extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.productService = (ProductService) getServletContext().getAttribute("ProductService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int intId = Integer.parseInt(id);

        Guitar guitar = productService.getProductById(intId);
        System.out.println(guitar);

        HttpSession session = request.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        if (basket != null) {
            basket.add(guitar);
        } else {
            basket = new Basket();
            basket.add(guitar);
        }
        session.setAttribute("basket", basket);

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(id);
        jsonArray.writeJSONString(response.getWriter());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
