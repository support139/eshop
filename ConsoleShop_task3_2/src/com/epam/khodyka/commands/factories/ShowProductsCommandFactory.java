package com.epam.khodyka.commands.factories;

import java.util.List;

import com.epam.khodyka.commands.AbstractFactory;
import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.impl.ShowProductsCommand;
import com.epam.khodyka.service.StorageService;

public class ShowProductsCommandFactory implements AbstractFactory {

	private StorageService storageService;

	public ShowProductsCommandFactory(StorageService storageService) {
		super();
		this.storageService = storageService;
	}

	@Override
	public Command getCommand(List<String> args) {
		return new ShowProductsCommand(storageService);
	}
}
