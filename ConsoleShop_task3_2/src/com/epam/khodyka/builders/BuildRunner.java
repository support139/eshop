package com.epam.khodyka.builders;

import com.epam.khodyka.db.entity.MusicalInstrument;

public class BuildRunner {

	AbstractBuilder builder;

	public void addBuilder(AbstractBuilder builder) {
		if (this.builder == null) {
			this.builder = builder;
		} else {
			this.builder.addBuilder(builder);
		}
	}

	public MusicalInstrument run(String productName) {
		return builder.create(productName);
	}
}
