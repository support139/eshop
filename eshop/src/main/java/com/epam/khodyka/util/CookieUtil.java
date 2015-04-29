package com.epam.khodyka.util;

import javax.servlet.http.Cookie;

public class CookieUtil {
	public static int getCaptchaId(Cookie[] cookies) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("captcha")) {
				return Integer.parseInt(cookie.getValue());
			}
		}
		return -1;
	}
}
