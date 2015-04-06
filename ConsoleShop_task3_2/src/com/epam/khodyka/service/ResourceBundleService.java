package com.epam.khodyka.service;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleService {

	public static ResourceBundle bundle = ResourceBundle.getBundle("resource",
			Locale.getDefault());

	public static void changeLocale(String language) {
		bundle = ResourceBundle.getBundle("resource", new Locale(language));
	}

	public static  ResourceBundle getBundle() {
		return bundle;
	}
}
