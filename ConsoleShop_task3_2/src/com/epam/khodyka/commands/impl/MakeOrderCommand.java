package com.epam.khodyka.commands.impl;

import java.util.Date;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.OrderService;
import com.epam.khodyka.view.ViewName;

public class MakeOrderCommand extends Command {

	private OrderService orderService;
	private Date orderDate;

	public MakeOrderCommand(OrderService orderService, Date orderDate) {
		this.orderService = orderService;
		this.orderDate = orderDate;
	}

	@Override
	public String execute(Model model) {
		if (orderService.makeOrder(orderDate)) {
			model.put("orderDate", orderDate);
			return ViewName.SUCCESSFUL_ORDER_VIEW;
		}
		model.put("errorMessage", "MakeOrder error");
		return ViewName.ERROR_VIEW;
	}
}
