package com.epam.khodyka.view.remote.impl;

import java.io.DataOutputStream;
import java.io.IOException;

import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.RemoteView;

public class GetCountHttpView implements RemoteView {
	// String response = "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n"
	// + "Content-Length: " + count.length() + "\r\n"
	// + "Connection: close\r\n\r\n";

	@Override
	public void show(Model model, DataOutputStream dataOutputStream) {
		Integer count = (Integer) model.get("count");
		String response = "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n"
				+ "Connection: close\r\n\r\n";
		String result = response + "{count: " + count + "}";
		try {
			dataOutputStream.writeUTF(result);
			dataOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
