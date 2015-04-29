package com.epam.khodyka.captcha.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.khodyka.bean.Captcha;
import com.epam.khodyka.captcha.AbstractMapCaptcha;
import com.epam.khodyka.util.CookieUtil;

public class CookieCaptchaImpl extends AbstractMapCaptcha {

	private int captchaExpiryTime;

	public CookieCaptchaImpl(int captchaExpiryTime) {
		super();
		this.captchaExpiryTime = captchaExpiryTime;
	}

	// @Override
	// public Captcha generateCaptcha(HttpServletRequest request,
	// HttpServletResponse response) {
	// Captcha captcha = super.createCaptcha(captchaExpiryTime);
	// Cookie catpchaCookie = new Cookie("captcha", String.valueOf(captcha
	// .getId()));
	// System.out.println("gg");
	// putCaptcha(captcha);
	// response.addCookie(catpchaCookie);
	// return captcha;
	// }

	@Override
	public Captcha createCaptcha() {
		return super.createCaptcha(captchaExpiryTime);
	};
	
	@Override
	public void saveCaptcha(Captcha captcha, HttpServletRequest request,
			HttpServletResponse response) {
		Cookie captchaCookie = new Cookie("captcha", String.valueOf(captcha.getId()));
		putCaptcha(captcha);
		response.addCookie(captchaCookie);
	}

	@Override
	public boolean checkCaptcha(HttpServletRequest request) {
		int captchaId = CookieUtil.getCaptchaId(request.getCookies());
		Captcha captcha = getCaptcha(captchaId);
		removeInactiveCaptcha();
		return checkCaptcha(captcha, request);
	}
}
