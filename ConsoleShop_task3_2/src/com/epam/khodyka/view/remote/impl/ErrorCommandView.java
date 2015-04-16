package com.epam.khodyka.view.remote.impl;

import java.io.DataOutputStream;
import java.io.IOException;

import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.RemoteView;

public class ErrorCommandView implements RemoteView {
	@Override
	public void show(Model model, DataOutputStream dataOutputStream) {
		try {
			dataOutputStream.writeUTF("Wrong command");
			dataOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
