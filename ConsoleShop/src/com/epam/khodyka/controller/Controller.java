package com.epam.khodyka.controller;

import java.util.Scanner;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.CommandFactory;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;
import com.epam.khodyka.view.ViewFactory;
import com.epam.khodyka.view.implementation.WelcomeView;

public class Controller {

	private View view;
	private Model model;

	public Controller() {
		this.view = new WelcomeView();
		this.model = new Model();
	}

	public void start() {
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
		}
	}

	private void doCommand(String commandName) {
		Command command = CommandFactory.getInstance().getCommand(commandName);
		String viewName = command.execute(model);
		View view = ViewFactory.getInstance().getView(viewName);
		view.show(model);
	}

}
