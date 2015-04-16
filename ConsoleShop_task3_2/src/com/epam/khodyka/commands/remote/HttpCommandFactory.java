package com.epam.khodyka.commands.remote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.khodyka.commands.AbstractFactory;
import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.CommandName;
import com.epam.khodyka.commands.remote.factories.GetCountCommandFactory;
import com.epam.khodyka.commands.remote.factories.GetProductCommandFactory;
import com.epam.khodyka.commands.remote.impl.NoCommand;
import com.epam.khodyka.service.ServiceManager;

public class HttpCommandFactory {

	private static HttpCommandFactory factory;
	private ServiceManager manager;
	private Map<String, AbstractFactory> commands = new HashMap<>();

	private HttpCommandFactory(ServiceManager manager) {
		this.manager = manager;
		commands.put(CommandName.GET_COUNT_HTTPCOMMAND,
				new GetCountCommandFactory(this.manager.getStorageService(),
						true));
		commands.put(CommandName.GET_PRODUCT_HTTPCOMMAND,
				new GetProductCommandFactory(this.manager.getStorageService(),
						true));
		
	}

	public static HttpCommandFactory getInstance(ServiceManager manager) {
		if (factory == null) {
			factory = new HttpCommandFactory(manager);
		}
		return factory;
	}

	public Command getCommand(String command) {
		String commandName = parseCommandName(command);
		List<String> args = parseCommandArgs(command);
		if (!commands.containsKey(commandName)) {
			return new NoCommand();
		}
		return commands.get(commandName).getCommand(args);
	}

	private String parseCommandName(String command) {
		if (command.contains("?")) {
			return command.substring(0, command.indexOf('?'));
		}
		return command;
	}

	private List<String> parseCommandArgs(String command) {
		List<String> args = new ArrayList<>();
		if (command.contains("?")) {
			String tmp = command.substring(command.indexOf('?') + 1,
					command.length());
			args.add(tmp.split("=")[1]);
		}
		return args;

	}
}
