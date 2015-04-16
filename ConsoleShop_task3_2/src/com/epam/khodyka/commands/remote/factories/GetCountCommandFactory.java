package com.epam.khodyka.commands.remote.factories;

import java.util.List;

import com.epam.khodyka.commands.AbstractFactory;
import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.remote.impl.GetCountCommand;
import com.epam.khodyka.service.StorageService;

public class GetCountCommandFactory implements AbstractFactory {

	private StorageService storageService;
	private boolean isHttp;

	public GetCountCommandFactory(StorageService storageService, boolean isHttp) {
		this.storageService = storageService;
		this.isHttp = isHttp;
	}

	@Override
	public Command getCommand(List<String> args) {
		return new GetCountCommand(storageService, isHttp);
	}
}
