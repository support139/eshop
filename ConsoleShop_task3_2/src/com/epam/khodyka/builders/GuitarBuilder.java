package com.epam.khodyka.builders;

import com.epam.khodyka.builders.reflection.exception.InstrumentCreatorException;
import com.epam.khodyka.datadispatcher.DataDispatcher;
import com.epam.khodyka.db.entity.Guitar;
import com.epam.khodyka.db.entity.MusicalInstrument;

public class GuitarBuilder extends MusicalInstrumentBuilder {

	public GuitarBuilder(DataDispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public MusicalInstrument create(String productName)
			throws InstrumentCreatorException {
		if (productName.equals("Guitar")) {
			Guitar guitar = (Guitar) super.create(productName);
			guitar.setFretsNum(dispatcher.getIntData("Enter fretsNum: "));
			guitar.setStringType(dispatcher.getStringData("Enter stringType: "));
			guitar.setWoodType(dispatcher.getStringData("Enter woodType: "));
			return guitar;
		}
		return toNextBuilder(productName);
	}

	@Override
	public MusicalInstrument getInstrument() {
		return new Guitar();
	}

}
