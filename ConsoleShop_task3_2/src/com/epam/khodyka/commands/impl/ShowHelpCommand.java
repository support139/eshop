package com.epam.khodyka.commands.impl;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.ViewName;

public class ShowHelpCommand extends Command {

	@Override
	public String execute(Model model) {
		return ViewName.SHOW_HELP_VIEW;
	}
}
