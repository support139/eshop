package com.epam.khodyka.view.implementation;

import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;

public class SuccessfulCreateBuilderView implements View {

	@Override
	public void show(Model model) {
		String builderType = (String) model.get("builderType");
		System.out.println(builderType + " has been successfuly choosen");
	}
}
