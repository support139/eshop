package com.epam.khodyka.view.impl;

import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;

public class ErrorPageView implements View {
	@Override
	public void show(Model model) {
		String errorMessage = (String) model.get("errorMessage");
		System.err.println(errorMessage);
	}
}
