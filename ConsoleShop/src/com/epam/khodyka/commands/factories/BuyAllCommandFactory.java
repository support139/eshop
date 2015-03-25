package com.epam.khodyka.commands.factories;

import java.util.List;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.implementation.BuyAllCommand;
import com.epam.khodyka.service.BasketService;

public class BuyAllCommandFactory implements AbstractFactory {

	private BasketService basketService;

	public BuyAllCommandFactory(BasketService basketService) {
		this.basketService = basketService;
	}

	@Override
	public Command getCommand(List<String> args) {
		return new BuyAllCommand(basketService);
	}
}
