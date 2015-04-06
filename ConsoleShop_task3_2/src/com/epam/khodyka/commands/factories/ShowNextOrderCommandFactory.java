package com.epam.khodyka.commands.factories;

import java.util.Date;
import java.util.List;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.implementation.ShowNextOrderCommand;
import com.epam.khodyka.service.OrderService;
import com.epam.khodyka.utils.DateFormatter;

public class ShowNextOrderCommandFactory implements AbstractFactory {

	private OrderService orderService;

	public ShowNextOrderCommandFactory(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@Override
	public Command getCommand(List<String> args) {
		String orderDate = args.get(0) + " " + args.get(1);
		Date date = DateFormatter.toDate(orderDate);
		return new ShowNextOrderCommand(orderService, date);
	}
}
