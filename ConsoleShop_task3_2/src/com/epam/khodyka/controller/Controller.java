package com.epam.khodyka.controller;

import java.util.Scanner;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.CommandFactory;
import com.epam.khodyka.controller.http.HttpController;
import com.epam.khodyka.controller.tcp.TcpController;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.ServiceManager;
import com.epam.khodyka.view.View;
import com.epam.khodyka.view.ViewFactory;
import com.epam.khodyka.view.impl.WelcomeView;

public class Controller {

	private View view;
	private Model model;
	private ServiceManager manager;
	private TcpController tcpController;
	private HttpController httpController;

	public Controller() {
		this.view = new WelcomeView();
		this.model = new Model();
		this.manager = new ServiceManager();
		this.tcpController = new TcpController(model, manager, 3000);
		this.httpController = new HttpController(model, manager, 3001);
	}

	public void start() {
		manager.getStorageService().load();
		view.show(model);
		runConsole();
	}

	private void runConsole() {
		String command = "";
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextLine()) {
				command = scanner.nextLine();
				if (command.equals("exit")) {
					break;
				}
				doCommand(command);
			}
		} finally {
			manager.getStorageService().save();
		}
	}

	private void doCommand(String commandName) {
		Command command = CommandFactory.getInstance(manager).getCommand(
				commandName);
		String viewName = command.execute(model);
		View view = ViewFactory.getInstance().getView(viewName);
		view.show(model);
	}

}
