package com.epam.khodyka.builders;

import com.epam.khodyka.dataDispatcher.DataDispatcher;
import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.db.entity.Violin;

public class ViolinBuilder extends MusicalInstrumentBuilder {

	public ViolinBuilder(DataDispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	MusicalInstrument create(String productName) {
		if (productName.equals("Violin")) {
			Violin violin = (Violin) super.create(productName);
			violin.setWoodType(dispatcher.getStringData("Enter woodType: "));
			violin.setStringType(dispatcher.getStringData("Enter stringType: "));
			violin.setScaleLenght(dispatcher
					.getDoubleData("Enter scale lenght: "));
			return violin;
		}
		return toNextBuilder(productName);

	}

	@Override
	public MusicalInstrument getInstrument() {
		return new Violin();
	}
}
