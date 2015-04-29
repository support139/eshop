package com.epam.khodyka.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.khodyka.bean.Captcha;
import com.epam.khodyka.captcha.CaptchaService;

@WebServlet("/Captcha")
public class CaptchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CaptchaService captchaService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.captchaService = (CaptchaService) getServletContext()
				.getAttribute("CaptchaService");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.captchaService = (CaptchaService) config.getServletContext()
				.getAttribute("CaptchaService");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Captcha captcha = captchaService.createCaptcha();
		captchaService.saveCaptcha(captcha, request, response);
		captchaService.draw(captcha, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
