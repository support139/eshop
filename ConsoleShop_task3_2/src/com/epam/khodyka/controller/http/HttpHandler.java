package com.epam.khodyka.controller.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.remote.HttpCommandFactory;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.ServiceManager;
import com.epam.khodyka.view.RemoteView;
import com.epam.khodyka.view.remote.RemoteViewFactory;

public class HttpHandler extends Thread {

	private Socket socket;
	private InputStream in;
	private OutputStream out;
	private Model model;
	private ServiceManager manager;

	public HttpHandler(Socket socket, Model model, ServiceManager manager)
			throws IOException {
		this.socket = socket;
		this.in = socket.getInputStream();
		this.out = socket.getOutputStream();
		this.model = model;
		this.manager = manager;
		start();
	}

	@Override
	public void run() {
		try {
			DataOutputStream dataOutputStream = new DataOutputStream(out);
			String commandName = HttpParser.parseCommandString(readRequest());
			doCommand(commandName, dataOutputStream);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void doCommand(String commandName, DataOutputStream dataOutputStream) {
		Command command = HttpCommandFactory.getInstance(manager).getCommand(
				commandName);
		String viewName = command.execute(model);
		RemoteView view = RemoteViewFactory.getInstance().getView(viewName);
		view.show(model, dataOutputStream);
	}

	private String readRequest() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder requestContain = new StringBuilder();
		while (true) {
			String s = reader.readLine();
			requestContain.append(s).append(System.lineSeparator());
			if (s == null || s.trim().length() == 0) {
				break;
			}
		}
		return requestContain.toString();
	}

}
