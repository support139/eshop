package com.epam.khodyka.servlet;

import com.epam.khodyka.service.PictureService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrii_Khodyka on 4/30/2015.
 */

@WebServlet("/Avatar")
public class AvatarServlet extends HttpServlet {

    private PictureService pictureService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.pictureService = (PictureService) getServletContext().getAttribute("PictureService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pictureService.printAvatar(req, resp);
    }
}
