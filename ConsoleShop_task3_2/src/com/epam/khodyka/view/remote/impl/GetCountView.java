package com.epam.khodyka.view.remote.impl;

import java.io.DataOutputStream;
import java.io.IOException;

import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.RemoteView;

public class GetCountView implements RemoteView {

	@Override
	public void show(Model model, DataOutputStream dataOutputStream) {
		int productCount = (Integer) model.get("count");
		try {
			dataOutputStream.writeUTF("Amount of products: " + productCount);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
