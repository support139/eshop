package com.epam.khodyka.view.implementation;

import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;

public class SuccessfulChangedLocaleView implements View {

	@Override
	public void show(Model model) {
		String message = (String) model.get("locale");
		System.out.println(message);
	}
}
