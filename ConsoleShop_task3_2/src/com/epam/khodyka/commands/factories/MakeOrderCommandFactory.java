package com.epam.khodyka.commands.factories;

import java.util.Date;
import java.util.List;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.implementation.MakeOrderCommand;
import com.epam.khodyka.commands.implementation.NoCommand;
import com.epam.khodyka.service.OrderService;
import com.epam.khodyka.utils.DateFormatter;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class MakeOrderCommandFactory implements AbstractFactory {

	private OrderService orderService;

	public MakeOrderCommandFactory(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public Command getCommand(List<String> args) {
		if (args.size() != 2) {
			return new NoCommand();
		}
		String orderDate = args.get(0) + " " + args.get(1);
		Date date = DateFormatter.toDate(orderDate);
		return new MakeOrderCommand(orderService, date);
	}
}
