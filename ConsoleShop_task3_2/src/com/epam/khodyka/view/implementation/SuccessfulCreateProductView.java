package com.epam.khodyka.view.implementation;

import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;

public class SuccessfulCreateProductView implements View {

	@Override
	public void show(Model model) {
		MusicalInstrument instrument = (MusicalInstrument) model
				.get("createdProduct");
		System.out.println(instrument + " has been successful added!");
	}
}
