package com.epam.khodyka.db;

import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import com.epam.khodyka.db.bean.OrderBean;

public class OrderRepository {
	private Map<Date, OrderBean> orders = new TreeMap<>();

	public void add(Date date, OrderBean order) {
		orders.put(date, order);
	}

	public OrderBean get(Date date) {
		return orders.get(date);
	}

	public Map<Date, OrderBean> getAll() {
		return Collections.unmodifiableMap(orders);
	}
}
