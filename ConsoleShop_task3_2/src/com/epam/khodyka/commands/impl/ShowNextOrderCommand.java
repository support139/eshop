package com.epam.khodyka.commands.impl;

import java.util.Date;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.db.bean.OrderBean;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.OrderService;
import com.epam.khodyka.view.ViewName;

public class ShowNextOrderCommand extends Command {

	private OrderService orderService;
	private Date date;

	public ShowNextOrderCommand(OrderService orderService, Date date) {
		this.orderService = orderService;
		this.date = date;
	}

	@Override
	public String execute(Model model) {
		OrderBean order = orderService.getNextOrder(date);
		model.put("order", order);
		return ViewName.SHOW_ORDER_VIEW;
	}
}
