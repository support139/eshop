package com.epam.khodyka.commands.factories;

import java.util.Date;
import java.util.List;

import com.epam.khodyka.commands.AbstractFactory;
import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.impl.NoCommand;
import com.epam.khodyka.commands.impl.ShowOrderCommand;
import com.epam.khodyka.service.OrderService;
import com.epam.khodyka.utils.DateFormatter;

public class ShowOrderCommandFactory implements AbstractFactory {

	private OrderService orderService;

	public ShowOrderCommandFactory(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@Override
	public Command getCommand(List<String> args) {
		if (args.size() == 2) {
			String strDateFrom = args.get(0) + " " + args.get(1);
			Date from = DateFormatter.toDate(strDateFrom);
			return new ShowOrderCommand(orderService, from);
		}
		if (args.size() == 4) {
			String strDateFrom = args.get(0) + " " + args.get(1);
			String strDateTo = args.get(2) + " " + args.get(3);
			Date from = DateFormatter.toDate(strDateFrom);
			Date to = DateFormatter.toDate(strDateTo);
			return new ShowOrderCommand(orderService, from, to);
		}
		return new NoCommand();
	}
}
