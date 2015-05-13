package com.epam.khodyka.service;

import com.epam.khodyka.service.exception.UnsupportPictureFormatException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrii_Khodyka on 5/7/2015.
 */
public interface PictureService {

    void saveAvatar(HttpServletRequest request) throws IOException, ServletException, UnsupportPictureFormatException;

    void printAvatar(HttpServletRequest request, HttpServletResponse response);

    void printPicture(HttpServletRequest request, HttpServletResponse response);

}
