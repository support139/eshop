package com.epam.khodyka.view.remote.impl;

import java.io.DataOutputStream;
import java.io.IOException;

import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.RemoteView;

public class GetProductView implements RemoteView {

	@Override
	public void show(Model model, DataOutputStream dataOutputStream) {
		MusicalInstrument instrument = (MusicalInstrument) model.get("product");
		try {
			dataOutputStream.writeUTF(instrument.getName() + " | "
					+ instrument.getPrice());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
