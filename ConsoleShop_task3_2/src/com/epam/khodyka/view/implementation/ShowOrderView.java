package com.epam.khodyka.view.implementation;

import java.util.Date;
import java.util.Map;

import com.epam.khodyka.db.bean.OrderBean;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.View;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class ShowOrderView implements View {
	@SuppressWarnings("unchecked")
	@Override
	public void show(Model model) {
		OrderBean order = (OrderBean) model.get("order");
		if (order != null) {
			System.err.println(order);
			return;
		}
		Map<Date, OrderBean> orders = (Map<Date, OrderBean>) model
				.get("orders");
		if (orders != null && orders.size() != 0) {
			for (Map.Entry<Date, OrderBean> entry : orders.entrySet()) {
				System.err.println(entry.getKey() + " " + entry.getValue());
			}
		} else {
			System.err.println("No orsers");
		}
	}
}
