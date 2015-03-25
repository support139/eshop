package com.epam.khodyka.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.khodyka.commands.factories.AbstractFactory;
import com.epam.khodyka.commands.factories.AddProductCommandFactory;
import com.epam.khodyka.commands.factories.BuyAllCommandFactory;
import com.epam.khodyka.commands.factories.MakeOrderCommandFactory;
import com.epam.khodyka.commands.factories.ShowAdvertisingCommandFactory;
import com.epam.khodyka.commands.factories.ShowBasketCommandFactory;
import com.epam.khodyka.commands.factories.ShowHelpCommandFactory;
import com.epam.khodyka.commands.factories.ShowNextOrderCommandFactory;
import com.epam.khodyka.commands.factories.ShowOrderCommandFactory;
import com.epam.khodyka.commands.factories.ShowProductsCommandFactory;
import com.epam.khodyka.commands.implementation.NoCommand;
import com.epam.khodyka.service.ServiceManager;

public class CommandFactory {

	private static CommandFactory factory;
	private Map<String, AbstractFactory> commands = new HashMap<>();

	private CommandFactory() {
		ServiceManager manager = new ServiceManager();
		commands.put(
				CommandName.ADD_PRODUCT_COMMAND,
				new AddProductCommandFactory(manager.getBasketService(),
						manager.getStorageService(), manager
								.getAdvertisingService()));
		commands.put(CommandName.BUY_ALL,
				new BuyAllCommandFactory(manager.getBasketService()));
		commands.put(CommandName.MAKE_ORDER_COMMAND,
				new MakeOrderCommandFactory(manager.getOrderService()));
		commands.put(
				CommandName.SHOW_ADVERTISING_COMMAND,
				new ShowAdvertisingCommandFactory(manager
						.getAdvertisingService()));
		commands.put(CommandName.SHOW_BASKET_COMAND,
				new ShowBasketCommandFactory(manager.getBasketService()));
		commands.put(CommandName.SHOW_HELP_COMMAND,
				new ShowHelpCommandFactory());
		commands.put(CommandName.SHOW_NEXT_ORDER_COMMAND,
				new ShowNextOrderCommandFactory(manager.getOrderService()));
		commands.put(CommandName.SHOW_ORDER_COMMAND,
				new ShowOrderCommandFactory(manager.getOrderService()));
		commands.put(CommandName.SHOW_PRODUCT_COMMAND,
				new ShowProductsCommandFactory(manager.getStorageService()));
	}

	public static CommandFactory getInstance() {
		if (factory == null) {
			factory = new CommandFactory();
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
