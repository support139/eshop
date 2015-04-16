package com.epam.khodyka.view.remote.impl;

import java.io.DataOutputStream;
import java.io.IOException;

import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.RemoteView;

public class GetProductHttpView implements RemoteView {

	@Override
	public void show(Model model, DataOutputStream dataOutputStream) {
		MusicalInstrument instrument = (MusicalInstrument) model.get("product");
		String response = "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n"
				+ "Connection: close\r\n\r\n";
		String result = response + "{name: " + instrument.getName()
				+ ", price:" + instrument.getPrice() + "}";
		try {
			dataOutputStream.writeUTF(result);
			dataOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
