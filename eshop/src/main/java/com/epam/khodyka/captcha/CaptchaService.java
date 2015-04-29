package com.epam.khodyka.captcha;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.khodyka.bean.Captcha;

public interface CaptchaService {

	// Captcha generateCaptcha(HttpServletRequest request,
	// HttpServletResponse response);

	Captcha createCaptcha();

	void saveCaptcha(Captcha captcha, HttpServletRequest request,
					 HttpServletResponse response);

	void draw(Captcha captcha, HttpServletResponse response) throws IOException;

	boolean checkCaptcha(HttpServletRequest request);

}
