package com.epam.khodyka.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class BasketRepository {

	private Map<Long, Integer> basket = new HashMap<>();

	public void addProduct(Long productId, int amount) {
		basket.put(productId, amount);
	}

	public Map<Long, Integer> getAll() {
		return Collections.unmodifiableMap(basket);
	}

	public void removeAll() {
		basket.clear();
	}
}
