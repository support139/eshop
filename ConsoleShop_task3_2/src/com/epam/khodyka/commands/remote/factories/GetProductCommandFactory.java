package com.epam.khodyka.commands.remote.factories;

import java.util.List;

import com.epam.khodyka.commands.AbstractFactory;
import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.remote.impl.GetProductCommand;
import com.epam.khodyka.service.StorageService;

public class GetProductCommandFactory implements AbstractFactory {

	private StorageService storageService;
	private boolean isHttp;

	public GetProductCommandFactory(StorageService storageService,
			boolean isHttp) {
		this.storageService = storageService;
		this.isHttp = isHttp;
	}

	@Override
	public Command getCommand(List<String> args) {
		long productId = Long.parseLong(args.get(0));
		return new GetProductCommand(storageService, productId, isHttp);
	}
}
