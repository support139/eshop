package com.epam.khodyka.view.implementation;

import java.util.Map;

import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class ShowProductView implements View {

	@SuppressWarnings("unchecked")
	@Override
	public void show(Model model) {
		Map<Long, MusicalInstrument> map = (Map<Long, MusicalInstrument>) model
				.get("products");
		for (Map.Entry<Long, MusicalInstrument> entry : map.entrySet()) {
			System.err.println(entry.getValue());
		}
	}

}
