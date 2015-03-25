package com.epam.khodyka.view.implementation;

import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;

public class WelcomeView implements View {

	private static final String WELCOME_MESSAGE = "Welcome to console shop! Use 'help' to show command list...";

	public void show(Model model) {
		System.err.println(WELCOME_MESSAGE);
	}

}
