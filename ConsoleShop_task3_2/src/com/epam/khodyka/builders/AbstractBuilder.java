package com.epam.khodyka.builders;

import com.epam.khodyka.builders.reflection.exception.InstrumentCreatorException;
import com.epam.khodyka.db.entity.MusicalInstrument;

public abstract class AbstractBuilder {

	private AbstractBuilder nextBuilder;

	abstract MusicalInstrument create(String productName) throws InstrumentCreatorException;

	public void addBuilder(AbstractBuilder builder) {
		if (this.nextBuilder == null) {
			this.nextBuilder = builder;
		} else {
			this.nextBuilder.addBuilder(builder);
		}
	}

	public boolean hasNextBuilder() {
		return nextBuilder != null;
	}

	public MusicalInstrument toNextBuilder(String productName) throws InstrumentCreatorException {
		return nextBuilder.create(productName);
	}

}
