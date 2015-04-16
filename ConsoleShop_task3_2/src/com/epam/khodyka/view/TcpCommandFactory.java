package com.epam.khodyka.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.khodyka.commands.AbstractFactory;
import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.CommandName;
import com.epam.khodyka.commands.impl.NoCommand;
import com.epam.khodyka.commands.remote.factories.GetCountCommandFactory;
import com.epam.khodyka.commands.remote.factories.GetProductCommandFactory;
import com.epam.khodyka.service.ServiceManager;

public class TcpCommandFactory {

	private static TcpCommandFactory factory;
	private ServiceManager manager;
	private Map<String, AbstractFactory> commands = new HashMap<>();

	private TcpCommandFactory(ServiceManager manager) {
		this.manager = manager;
		commands.put(CommandName.GET_COUNT_TCPCOMMAND,
				new GetCountCommandFactory(this.manager.getStorageService(),
						false));
		commands.put(CommandName.GET_PRODUCT_TCPCOMMAND,
				new GetProductCommandFactory(this.manager.getStorageService(),
						false));
	}

	public static TcpCommandFactory getInstance(ServiceManager manager) {
		if (factory == null) {
			factory = new TcpCommandFactory(manager);
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
		return command.trim().split("\\s")[0];
	}

	private List<String> parseCommandArgs(String command) {
		return Arrays.asList(command.trim()
				.substring(command.indexOf(" ") + 1, command.length())
				.split("\\s"));

	}

}
