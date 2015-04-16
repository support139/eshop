package com.epam.khodyka.commands.factories;

import java.util.List;

import com.epam.khodyka.commands.AbstractFactory;
import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.impl.AddProductCommand;
import com.epam.khodyka.service.AdvertisingService;
import com.epam.khodyka.service.BasketService;
import com.epam.khodyka.service.StorageService;

public class AddProductCommandFactory implements AbstractFactory {

	private BasketService basketService;
	private StorageService storageService;
	private AdvertisingService advertisingService;

	public AddProductCommandFactory(BasketService basketService,
			StorageService storageService, AdvertisingService advertisingService) {
		this.basketService = basketService;
		this.storageService = storageService;
		this.advertisingService = advertisingService;
	}

	public Command getCommand(List<String> args) {
		if (args.size() == 2) {
			return new AddProductCommand(basketService, storageService,
					advertisingService, Long.valueOf(args.get(0)),
					Integer.valueOf(args.get(1)));
		}
		if (args.size() == 1) {
			return new AddProductCommand(basketService, storageService,
					advertisingService, Long.valueOf(args.get(0)));
		}
		return null;
	}
}
