package com.epam.khodyka.commands.impl;

import com.epam.khodyka.builders.BuilderFactory;
import com.epam.khodyka.commands.Command;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.ViewName;

public class CreateProductBuilderCommand extends Command {

	private String builderType;

	public CreateProductBuilderCommand(String builderType) {
		this.builderType = builderType;
	}

	@Override
	public String execute(Model model) {
		if (!BuilderFactory.getInstance().BuildRunnerInitiator(builderType)) {
			model.put("errorMessage", "Builder already choosen");
			return ViewName.ERROR_VIEW;
		}
		model.put("builderType", builderType);
		return ViewName.SUCCESSFUL_CREATE_BUILDER_VIEW;
	}
}
