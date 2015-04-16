package com.epam.khodyka.commands.impl;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.BasketService;
import com.epam.khodyka.view.ViewName;

public class BuyAllCommand extends Command {

	private BasketService basketService;

	public BuyAllCommand(BasketService basketService) {
		this.basketService = basketService;
	}

	@Override
	public String execute(Model model) {
		double totalPrice = basketService.BuyAllProducts();
		if (totalPrice == 0) {
			model.put("errorMessage", "Your basket is empty!");
			return ViewName.ERROR_VIEW;
		}
		model.put("totalPrice", totalPrice);
		return ViewName.SHOW_TOTAL_ORDER_VIEW;
	}
}
