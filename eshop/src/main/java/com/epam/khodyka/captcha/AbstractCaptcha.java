package com.epam.khodyka.captcha;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.khodyka.bean.Captcha;
import com.github.cage.Cage;

public abstract class AbstractCaptcha implements CaptchaService {

	private Cage cage;

	public AbstractCaptcha() {
		this.cage = new Cage();
	}
	
	public Captcha createCaptcha(int captchaExpiryTime) {
		String token = cage.getTokenGenerator().next().substring(0, 5);
		int id = token.hashCode();
		Captcha captcha = new Captcha(id, token, captchaExpiryTime);
		return captcha;
	}

	@Override
	public void draw(Captcha captcha, HttpServletResponse response)
			throws IOException {
		cage.draw(captcha.getToken(), response.getOutputStream());
	}
	
	public boolean checkCaptcha(Captcha captcha, HttpServletRequest request) {
		boolean isValid = true;
		if (new Date().after(captcha.getExpiryTime())) {
			isValid = false;
		}
		if (!captcha.getToken().equals(request.getParameter("captchaValue"))) {
			isValid = false;
		}
		return isValid;
	}

}
