package com.epam.khodyka.captcha.impl;

import com.epam.khodyka.bean.Captcha;
import com.epam.khodyka.captcha.AbstractMapCaptcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiddenFieldCaptchaImpl extends AbstractMapCaptcha {

	private int captchaExpiryTime;

	public HiddenFieldCaptchaImpl(int captchaExpiryTime) {
		this.captchaExpiryTime = captchaExpiryTime;
	}

//	@Override
//	public Captcha generateCaptcha(HttpServletRequest request,
//			HttpServletResponse response) {
//		int captchaId = Integer.parseInt(request
//				.getParameter("hiddenCaptchaId"));
//		Captcha captcha = super.createCaptcha(captchaExpiryTime);
//		captcha.setId(captchaId);
//		putCaptcha(captcha);
//		return captcha;
//	}
	
	@Override
	public Captcha createCaptcha() {
		return super.createCaptcha(captchaExpiryTime);
	};
	
	@Override
	public void saveCaptcha(Captcha captcha, HttpServletRequest request,
			HttpServletResponse response) {
		int captchaId = Integer.parseInt(request.getParameter("hiddenCaptchaId"));
		captcha.setId(captchaId);
		putCaptcha(captcha);
	} 
	
	@Override
	public boolean checkCaptcha(HttpServletRequest request) {
		int captchaId = Integer.parseInt(request.getParameter("captcha"));
		Captcha captcha = getCaptcha(captchaId);
		removeInactiveCaptcha();
		return checkCaptcha(captcha, request);
	}

}
