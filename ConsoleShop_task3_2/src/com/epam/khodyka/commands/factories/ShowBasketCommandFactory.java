package com.epam.khodyka.commands.factories;

import java.util.List;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.implementation.ShowBasketCommand;
import com.epam.khodyka.service.BasketService;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class ShowBasketCommandFactory implements AbstractFactory {

	private BasketService basketService;

	public ShowBasketCommandFactory(BasketService basketService) {
		this.basketService = basketService;
	}

	@Override
	public Command getCommand(List<String> args) {
		return new ShowBasketCommand(basketService);
	}
}
