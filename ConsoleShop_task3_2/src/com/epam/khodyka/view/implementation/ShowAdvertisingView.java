package com.epam.khodyka.view.implementation;

import java.util.List;

import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class ShowAdvertisingView implements View {
	@SuppressWarnings("unchecked")
	@Override
	public void show(Model model) {
		List<MusicalInstrument> advertisingList = (List<MusicalInstrument>) model
				.get("advertisingList");
		for (MusicalInstrument instrument : advertisingList) {
			System.err.println(instrument);
		}
	}
}
