package com.epam.khodyka.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.khodyka.commands.factories.AbstractFactory;
import com.epam.khodyka.commands.factories.AddProductCommandFactory;
import com.epam.khodyka.commands.factories.BuyAllCommandFactory;
import com.epam.khodyka.commands.factories.ChangeLocaleCommandFactory;
import com.epam.khodyka.commands.factories.CreateProductBuilderCommandFactory;
import com.epam.khodyka.commands.factories.CreateProductCommandFactory;
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
	private ServiceManager manager;
	private Map<String, AbstractFactory> commands = new HashMap<>();

	private CommandFactory(ServiceManager manager) {
		this.manager = manager;
		commands.put(
				CommandName.ADD_PRODUCT_COMMAND,
				new AddProductCommandFactory(this.manager.getBasketService(),
						manager.getStorageService(), manager
								.getAdvertisingService()));
		commands.put(CommandName.BUY_ALL,
				new BuyAllCommandFactory(this.manager.getBasketService()));
		commands.put(CommandName.MAKE_ORDER_COMMAND,
				new MakeOrderCommandFactory(this.manager.getOrderService()));
		commands.put(
				CommandName.SHOW_ADVERTISING_COMMAND,
				new ShowAdvertisingCommandFactory(this.manager
						.getAdvertisingService()));
		commands.put(CommandName.SHOW_BASKET_COMAND,
				new ShowBasketCommandFactory(this.manager.getBasketService()));
		commands.put(CommandName.SHOW_HELP_COMMAND,
				new ShowHelpCommandFactory());
		commands.put(CommandName.SHOW_NEXT_ORDER_COMMAND,
				new ShowNextOrderCommandFactory(this.manager.getOrderService()));
		commands.put(CommandName.SHOW_ORDER_COMMAND,
				new ShowOrderCommandFactory(this.manager.getOrderService()));
		commands.put(
				CommandName.SHOW_PRODUCT_COMMAND,
				new ShowProductsCommandFactory(this.manager.getStorageService()));
		commands.put(
				CommandName.CREATE_NEW_PRODUCT_COMMAND,
				new CreateProductCommandFactory(this.manager
						.getStorageService()));
		commands.put(CommandName.CREATE_NEW_PRODUCT_BUILDER,
				new CreateProductBuilderCommandFactory());
		commands.put(
				CommandName.CHANGE_LOCALE_COMMAND,
				new ChangeLocaleCommandFactory(this.manager
						.getResourceBundleService()));
	}

	public static CommandFactory getInstance(ServiceManager manager) {
		if (factory == null) {
			factory = new CommandFactory(manager);
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
