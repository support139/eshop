package com.epam.khodyka.view.impl;

import java.util.Map;

import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;

public class SuccessfulAddedView implements View {

	@SuppressWarnings("unchecked")
	@Override
	public void show(Model model) {
		Map<MusicalInstrument, Integer> map = (Map<MusicalInstrument, Integer>) model
				.get("purchase");
		for (Map.Entry<MusicalInstrument, Integer> entry : map.entrySet()) {
			System.err.println(entry.getValue() + " units of '"
					+ entry.getKey()
					+ "' has been successfully added to basket");
		}
	}
}
