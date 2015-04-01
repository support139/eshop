package com.epam.khodyka.commands.implementation;

import java.util.Map;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.BasketService;
import com.epam.khodyka.view.ViewName;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class ShowBasketCommand extends Command {

	private BasketService basketService;

	public ShowBasketCommand(BasketService basketService) {
		this.basketService = basketService;
	}

	@Override
	public String execute(Model model) {
		Map<MusicalInstrument, Integer> basket = basketService.getBasketContain();
		model.put("basket", basket);
		return ViewName.SHOW_BASKET_VIEW;
	}
}
