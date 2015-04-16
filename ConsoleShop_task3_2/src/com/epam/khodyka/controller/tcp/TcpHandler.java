package com.epam.khodyka.controller.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.remote.TcpCommandFactory;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.ServiceManager;
import com.epam.khodyka.view.RemoteView;
import com.epam.khodyka.view.remote.RemoteViewFactory;

public class TcpHandler extends Thread {

	private Socket socket;
	private Model model;
	private ServiceManager manager;

	public TcpHandler(Socket socket, Model model, ServiceManager manager)
			throws IOException {
		this.socket = socket;
		this.model = model;
		this.manager = manager;
		start();
	}

	@Override
	public void run() {
		try {
			DataInputStream dataInputStream = new DataInputStream(
					socket.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(
					socket.getOutputStream());
			String commandName = dataInputStream.readUTF();
			doCommand(commandName, dataOutputStream);
			socket.close();
		} catch (IOException e) {
			System.err.println("IOException in connectHandler");
		}
	}

	private void doCommand(String commandName, DataOutputStream dataOutputStream) {
		Command command = TcpCommandFactory.getInstance(manager).getCommand(
				commandName);
		String viewName = command.execute(model);
		RemoteView view = RemoteViewFactory.getInstance().getView(viewName);
		view.show(model, dataOutputStream);
	}
}
