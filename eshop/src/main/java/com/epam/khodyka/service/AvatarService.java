package com.epam.khodyka.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrii_Khodyka on 5/7/2015.
 */
public interface AvatarService {

    void writeAvatar(HttpServletRequest request) throws IOException, ServletException;

    void readAvatar(HttpServletRequest request, HttpServletResponse response);

}
