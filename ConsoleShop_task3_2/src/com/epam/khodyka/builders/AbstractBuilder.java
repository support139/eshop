package com.epam.khodyka.builders;

import com.epam.khodyka.db.entity.MusicalInstrument;

public abstract class AbstractBuilder {

	private AbstractBuilder nextBuilder;

	abstract MusicalInstrument create(String productName);

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

	public MusicalInstrument toNextBuilder(String productName) {
		return nextBuilder.create(productName);
	}

}
