package com.epam.khodyka.builders;

import com.epam.khodyka.dataDispatcher.DataDispatcher;
import com.epam.khodyka.db.entity.MusicalInstrument;

public abstract class MusicalInstrumentBuilder extends AbstractBuilder {

	protected DataDispatcher dispatcher;

	public MusicalInstrumentBuilder(DataDispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	@Override
	MusicalInstrument create(String productName) {
		MusicalInstrument instrument = getInstrument();
		instrument.setId(dispatcher.getLongData("Enter id: "));
		instrument.setName(dispatcher.getStringData("Enter name: "));
		instrument.setPrice(dispatcher.getDoubleData("Enter price: "));
		return instrument;
	}

	public abstract MusicalInstrument getInstrument();
}
