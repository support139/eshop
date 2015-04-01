package com.epam.khodyka.commands.factories;

import java.util.List;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.implementation.CreateProductCommand;
import com.epam.khodyka.service.StorageService;

public class CreateProductCommandFactory implements AbstractFactory {

	private StorageService storageService;

	public CreateProductCommandFactory(StorageService storageService) {
		this.storageService = storageService;
	}

	@Override
	public Command getCommand(List<String> args) {
		return new CreateProductCommand(args.get(0), storageService);
	}

}
