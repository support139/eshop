package com.epam.khodyka.captcha.impl;

import com.epam.khodyka.bean.Captcha;
import com.epam.khodyka.captcha.AbstractCaptcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionCapthaImpl extends AbstractCaptcha {

	private int captchaExpiryTime;

	public SessionCapthaImpl(int captchaExpiryTime) {
		this.captchaExpiryTime = captchaExpiryTime;
	}

//	@Override
//	public Captcha generateCaptcha(HttpServletRequest request,
//			HttpServletResponse response) {
//		Captcha captcha = super.createCaptcha(captchaExpiryTime);
//		request.getSession().setAttribute("captcha", captcha);
//		return captcha;
//	}
	
	@Override
	public Captcha createCaptcha() {
		return super.createCaptcha(captchaExpiryTime);
	}
	
	@Override
	public void saveCaptcha(Captcha captcha, HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().setAttribute("captcha", captcha);
	}

	@Override
	public boolean checkCaptcha(HttpServletRequest request) {
		Captcha captcha = (Captcha) request.getSession()
				.getAttribute("captcha");
		request.getSession().removeAttribute("captcha");
		return checkCaptcha(captcha, request);
	}

}
