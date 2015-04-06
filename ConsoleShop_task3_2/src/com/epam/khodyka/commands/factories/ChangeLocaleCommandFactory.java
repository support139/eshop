package com.epam.khodyka.commands.factories;

import java.util.List;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.implementation.ChangeLocaleCommand;
import com.epam.khodyka.service.ResourceBundleService;

public class ChangeLocaleCommandFactory implements AbstractFactory {

	private ResourceBundleService bundleService;

	public ChangeLocaleCommandFactory(ResourceBundleService bundleService) {
		this.bundleService = bundleService;
	}

	@Override
	public Command getCommand(List<String> args) {
		return new ChangeLocaleCommand(args.get(0), bundleService);
	}
}
