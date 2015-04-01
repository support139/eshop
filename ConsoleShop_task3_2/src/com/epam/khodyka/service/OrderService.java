package com.epam.khodyka.service;

import java.util.Date;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import com.epam.khodyka.db.BasketRepository;
import com.epam.khodyka.db.OrderRepository;
import com.epam.khodyka.db.StorageRepository;
import com.epam.khodyka.db.bean.OrderBean;
import com.epam.khodyka.db.entity.MusicalInstrument;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class OrderService {

	private BasketRepository basketRepository;
	private StorageRepository storageRepository;
	private OrderRepository orderRepository;

	public OrderService(BasketRepository basketRepository,
			StorageRepository storageRepository, OrderRepository orderRepository) {
		this.basketRepository = basketRepository;
		this.storageRepository = storageRepository;
		this.orderRepository = orderRepository;
	}

	public boolean makeOrder(Date date) {
		Map<Long, Integer> map = basketRepository.getAll();
		if (map.isEmpty()) {
			return false;
		}
		OrderBean order = new OrderBean();
		for (Map.Entry<Long, Integer> entry : map.entrySet()) {
			MusicalInstrument instrument = storageRepository.getProduct(entry
					.getKey());
			order.add(instrument);
		}
		orderRepository.add(date, order);
		basketRepository.removeAll();
		return true;
	}

	public OrderBean getOrder(Date date) {
		return orderRepository.get(date);
	}

	public Map<Date, OrderBean> getOrdersInTheRange(Date from, Date to) {
		Map<Date, OrderBean> orders = orderRepository.getAll();
		Map<Date, OrderBean> atRangeOrders = new TreeMap<Date, OrderBean>();
		for (Map.Entry<Date, OrderBean> entry : orders.entrySet()) {
			if (entry.getKey().getTime() > from.getTime()
					&& entry.getKey().getTime() < to.getTime()) {
				atRangeOrders.put(entry.getKey(), entry.getValue());
			}
		}
		return atRangeOrders;
	}

	public OrderBean getNextOrder(Date date) {
		NavigableMap<Date, OrderBean> orders = (NavigableMap<Date, OrderBean>) orderRepository
				.getAll();
		Date higherDate = orders.higherKey(date);
		Date lowerDate = orders.lowerKey(date);
		if (higherDate == null && lowerDate == null) {
			return null;
		}
		if (higherDate == null && lowerDate != null) {
			return orders.get(lowerDate);
		}
		if (lowerDate == null && higherDate != null) {
			return orders.get(higherDate);
		}
		if (date.getTime() - lowerDate.getTime() < higherDate.getTime()
				- date.getTime()) {
			return orders.get(lowerDate);
		}
		return orders.get(higherDate);

	}
}
