package com.epam.khodyka.bean;

import java.util.Date;

public class Captcha {

	public final static int ONE_MINUTE = 1000 * 60;

	private int id;
	private String token;
	private long expiryTime;

	public Captcha(int id, String token, long expiryTime) {
		this.id = id;
		this.token = token;
		this.expiryTime = new Date().getTime() + expiryTime * ONE_MINUTE;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiryTime() {
		return new Date(expiryTime);
	}

	public void setExpiryTime(Date creationDate) {
		this.expiryTime = creationDate.getTime();
	}

}
