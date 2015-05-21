package com.epam.khodyka.servlet;

import com.epam.khodyka.bean.Basket;
import com.epam.khodyka.db.entiry.Guitar;
import com.epam.khodyka.service.ProductService;
import org.json.simple.JSONObject;

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
@WebServlet("/AddToBasket")
public class AddToBasketServlet extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.productService = (ProductService) getServletContext().getAttribute("ProductService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        Guitar guitar = productService.getProductById(productId);

        HttpSession session = request.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        basket.add(guitar);
        session.setAttribute("basket", basket);
        session.setAttribute("quantity", basket.getQuantity());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("quantity", basket.getQuantity());
        jsonObject.writeJSONString(response.getWriter());
    }
}
