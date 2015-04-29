package com.epam.khodyka.captcha;

import java.util.HashMap;
import java.util.Map;

import com.epam.khodyka.captcha.impl.CookieCaptchaImpl;
import com.epam.khodyka.captcha.impl.HiddenFieldCaptchaImpl;
import com.epam.khodyka.captcha.impl.SessionCapthaImpl;

public class CaptchaFactory {

	private static CaptchaFactory captchaFactory;
	private static Map<String, CaptchaService> services = new HashMap<>();

	private CaptchaFactory() {
	}

	public static CaptchaFactory getInstance(int captchaExpiryTime) {
		if (captchaFactory == null) {
			captchaFactory = new CaptchaFactory();
			services.put("session", new SessionCapthaImpl(captchaExpiryTime));
			services.put("cookie", new CookieCaptchaImpl(captchaExpiryTime));
			services.put("hidden", new HiddenFieldCaptchaImpl(captchaExpiryTime));
		}
		return captchaFactory;
	}

	public CaptchaService getCaptchaService(String captchaMode) {
		return services.get(captchaMode);
	}

}
