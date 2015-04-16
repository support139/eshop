package com.epam.khodyka.commands.impl;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.ResourceBundleService;
import com.epam.khodyka.view.ViewName;

public class ChangeLocaleCommand extends Command {

	private ResourceBundleService bundleService;
	private String language;

	public ChangeLocaleCommand(String language,
			ResourceBundleService bundleService) {
		this.language = language;
		this.bundleService = bundleService;
	}

	@Override
	public String execute(Model model) {
		ResourceBundleService.changeLocale(language);
		model.put("locale", "locale has been successfuly changed to "
				+ language);
		return ViewName.SUCCESSFUL_CHANGED_LOCALE_VIEW;
	}
}
