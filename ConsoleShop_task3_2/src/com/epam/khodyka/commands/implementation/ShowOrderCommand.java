package com.epam.khodyka.commands.implementation;

import java.util.Date;
import java.util.Map;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.db.bean.OrderBean;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.service.OrderService;
import com.epam.khodyka.view.ViewName;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class ShowOrderCommand extends Command {

	private OrderService orderService;
	private Date from;
	private Date to;

	public ShowOrderCommand(OrderService orderService, Date from, Date to) {
		this.orderService = orderService;
		this.from = from;
		this.to = to;
	}

	public ShowOrderCommand(OrderService orderService, Date from) {
		this.orderService = orderService;
		this.from = from;
	}

	@Override
	public String execute(Model model) {
		if (from != null && to == null) {
			return showOrder(model);
		}
		if (from != null && to != null) {
			return showOrdersInTheRange(model);
		}
		model.put("errorMessage", "Show order error");
		return ViewName.ERROR_VIEW;
	}

	private String showOrder(Model model) {
		OrderBean order = orderService.getOrder(from);
		model.put("order", order);
		return ViewName.SHOW_ORDER_VIEW;
	}

	private String showOrdersInTheRange(Model model) {
		Map<Date, OrderBean> orders = orderService.getOrdersInTheRange(
				from, to);
		model.put("orders", orders);
		return ViewName.SHOW_ORDER_VIEW;
	}
}
