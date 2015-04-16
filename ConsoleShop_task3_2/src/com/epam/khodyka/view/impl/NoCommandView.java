package com.epam.khodyka.view.impl;

import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;

public class NoCommandView implements View {
	private static final String NO_COMMAND_MESSAGE = "Wrong command. Use 'help' to show command list";

	@Override
	public void show(Model model) {
		System.err.println(NO_COMMAND_MESSAGE);
	}

}
