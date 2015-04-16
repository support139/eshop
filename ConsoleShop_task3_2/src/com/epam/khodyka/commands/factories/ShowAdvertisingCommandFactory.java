package com.epam.khodyka.commands.factories;

import java.util.List;

import com.epam.khodyka.commands.AbstractFactory;
import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.impl.ShowAdvertisingCommand;
import com.epam.khodyka.service.AdvertisingService;

public class ShowAdvertisingCommandFactory implements AbstractFactory {

	private AdvertisingService advertisingService;

	public ShowAdvertisingCommandFactory(AdvertisingService advertisingService) {
		super();
		this.advertisingService = advertisingService;
	}

	@Override
	public Command getCommand(List<String> args) {
		return new ShowAdvertisingCommand(advertisingService);
	}
}
