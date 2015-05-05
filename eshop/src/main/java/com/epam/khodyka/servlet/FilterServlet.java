package com.epam.khodyka.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrii_Khodyka on 5/7/2015.
 */

@WebServlet("/Filter")
public class FilterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println(Arrays.toString(req.getParameterValues("category")));
//        System.out.println(Arrays.toString(req.getParameterValues("brand")));
//        System.out.println(req.getParameter("minPrice"));
//        System.out.println(req.getParameter("maxPrice"));


    }
}
