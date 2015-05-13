package com.epam.khodyka.service.impl;

import com.epam.khodyka.db.Fields;
import com.epam.khodyka.service.PictureService;
import com.epam.khodyka.service.exception.UnsupportPictureFormatException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Andrii_Khodyka on 5/7/2015.
 */
public class LocalPictureService implements PictureService {

    private static final Logger LOG = Logger.getLogger(LocalPictureService.class);

    private static final String JPEG_CONTENT_TYPE = "image/jpeg";
    private static final String JPEG_EXTENSION = ".jpeg";

    @Override
    public void saveAvatar(HttpServletRequest request) throws IOException, ServletException, UnsupportPictureFormatException {
        String login = request.getParameter(Fields.USER_LOGIN);
        String path = request.getServletContext().getInitParameter("AvatarPath");
        String realPath = request.getServletContext().getRealPath(path) + File.separator;
        if (checkPictureExtends(request)) {
            request.getPart("avatar").write(realPath + login + JPEG_EXTENSION);
        } else {
            throw new UnsupportPictureFormatException();
        }
    }

    @Override
    public void printAvatar(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletContext().getInitParameter("AvatarPath");
        String realPath = request.getServletContext().getRealPath(path) + File.separator;
        String avatarFullPath = realPath + request.getParameter(Fields.AVATAR_ID) + JPEG_EXTENSION;
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(avatarFullPath));
             BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
        } catch (IOException e) {
            LOG.error("Cannot print avatar!", e);
        }
    }

    @Override
    public void printPicture(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletContext().getInitParameter("PicturePath");
        String realPath = request.getServletContext().getRealPath(path) + File.separator;
        String avatarFullPath = realPath + request.getParameter("picture");
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(avatarFullPath));
             BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
        } catch (IOException e) {
            LOG.error("Cannot print picture!", e);
        }
    }

    private boolean checkPictureExtends(HttpServletRequest request) throws IOException, ServletException {
        return request.getPart("avatar").getHeader("content-type").equals(JPEG_CONTENT_TYPE);
    }
}
