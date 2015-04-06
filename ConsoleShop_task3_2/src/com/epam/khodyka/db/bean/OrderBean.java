package com.epam.khodyka.db.bean;

import java.util.ArrayList;
import java.util.List;

import com.epam.khodyka.db.entity.MusicalInstrument;

public class OrderBean {
	private List<MusicalInstrument> instruments;

	public OrderBean() {
		instruments = new ArrayList<>();
	}

	public void add(MusicalInstrument instrument) {
		instruments.add(instrument);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (MusicalInstrument instrument : instruments) {
			sb.append(instrument + "\n");
		}
		return sb.toString();
	}

}
