package com.epam.khodyka.view.implementation;

import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class ErrorPageView implements View {
	@Override
	public void show(Model model) {
		String errorMessage = (String) model.get("errorMessage");
		System.err.println(errorMessage);
	}
}
