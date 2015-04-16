package com.epam.khodyka.view.impl;

import java.util.Map;

import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;

public class ShowBasketView implements View {

	@SuppressWarnings("unchecked")
	@Override
	public void show(Model model) {
		Map<MusicalInstrument, Integer> basket = (Map<MusicalInstrument, Integer>) model
				.get("basket");
		if (basket.isEmpty()) {
			System.err.println("Sorry! You backet is empty");
		} else {
			System.err.println("Backet contains");
			for (Map.Entry<MusicalInstrument, Integer> entry : basket
					.entrySet()) {
				System.err.println(entry.getKey() + " in amount of: "
						+ entry.getValue());
			}
		}
	}
}
