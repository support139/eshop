package com.epam.khodyka.service.impl;

import com.epam.khodyka.db.Fields;
import com.epam.khodyka.service.AvatarService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Andrii_Khodyka on 5/7/2015.
 */
public class LocalAvatarService implements AvatarService {

    private static final Logger LOG = Logger.getLogger(LocalAvatarService.class);

    @Override
    public void writeAvatar(HttpServletRequest request) throws IOException, ServletException {
        String login = request.getParameter(Fields.USER_LOGIN);
        String path = request.getServletContext().getInitParameter("AvatarPath");
        String realPath = request.getServletContext().getRealPath(path) + "\\";
        request.getPart("avatar").write(realPath + login + ".jpeg");
    }

    @Override
    public void readAvatar(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletContext().getInitParameter("AvatarPath");
        String realPath = request.getServletContext().getRealPath(path) + "\\";
        String avatarFullPath = realPath + request.getParameter(Fields.AVATAR_ID) + ".jpeg";
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(avatarFullPath));
             BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
        } catch (IOException e) {
            LOG.error("");
        }

    }
}
