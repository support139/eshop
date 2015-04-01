package com.epam.khodyka.service;

import java.util.HashMap;
import java.util.Map;

import com.epam.khodyka.db.BasketRepository;
import com.epam.khodyka.db.StorageRepository;
import com.epam.khodyka.db.entity.MusicalInstrument;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class BasketService {

	private BasketRepository basketRepository;
	private StorageRepository storageRepository;

	public BasketService(BasketRepository basketRepository,
			StorageRepository storageRepository) {
		this.basketRepository = basketRepository;
		this.storageRepository = storageRepository;
	}

	public Map<Long, Integer> getBasket() {
		return basketRepository.getAll();
	}

	public Map<MusicalInstrument, Integer> getBasketContain() {
		Map<MusicalInstrument, Integer> contains = new HashMap<>();
		for (Map.Entry<Long, Integer> entry : getBasket().entrySet()) {
			MusicalInstrument product = storageRepository.getProduct(entry
					.getKey());
			contains.put(product, entry.getValue());
		}
		return contains;
	}

	public void clearBacket() {
		basketRepository.removeAll();
	}

	public boolean addProduct(long productId, int amount) {
		if (!storageRepository.getAllProducts().containsKey(productId)) {
			return false;
		}
		Map<Long, Integer> backet = getBasket();
		if (backet.containsKey(productId)) {
			int newAmount = backet.get(productId);
			newAmount += amount;
			basketRepository.addProduct(productId, newAmount);
			return true;
		} else {
			basketRepository.addProduct(productId, amount);
			return true;
		}
	}

	public Double BuyAllProducts() {
		Double total = getTotalAmout();
		clearBacket();
		return total;
	}

	private double getTotalAmout() {
		Map<Long, Integer> backet = getBasket();
		double total = 0;
		for (Map.Entry<Long, Integer> entry : backet.entrySet()) {
			total += storageRepository.getProduct(entry.getKey()).getPrice()
					* entry.getValue();
		}
		return total;
	}
}
