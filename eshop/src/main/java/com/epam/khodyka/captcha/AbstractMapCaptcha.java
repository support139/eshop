package com.epam.khodyka.captcha;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.epam.khodyka.bean.Captcha;

public abstract class AbstractMapCaptcha extends AbstractCaptcha {

	private ConcurrentMap<Integer, Captcha> capthcaMap;

	public AbstractMapCaptcha() {
		this.capthcaMap = new ConcurrentHashMap<>();
	}

	public void putCaptcha(Captcha captcha) {
		capthcaMap.put(captcha.getId(), captcha);
	}

	public Captcha getCaptcha(int id) {
		return capthcaMap.get(id);
	}

	public void removeInactiveCaptcha() {
		for (Map.Entry<Integer, Captcha> entry : capthcaMap.entrySet()) {
			if (new Date().after(entry.getValue().getExpiryTime())) {
				capthcaMap.remove(entry.getKey());
			}
		}
	}
}
