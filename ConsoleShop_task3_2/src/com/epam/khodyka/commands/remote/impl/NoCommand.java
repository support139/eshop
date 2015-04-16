package com.epam.khodyka.commands.remote.impl;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.ViewName;

public class NoCommand extends Command {

	@Override
	public String execute(Model model) {
		return ViewName.ERROR_REMOTE_VIEW;
	}

}
