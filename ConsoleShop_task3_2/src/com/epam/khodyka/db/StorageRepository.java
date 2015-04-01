package com.epam.khodyka.db;

import java.util.HashMap;
import java.util.Map;

import com.epam.khodyka.db.entity.Guitar;
import com.epam.khodyka.db.entity.MusicalInstrument;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class StorageRepository {

	private Map<Long, MusicalInstrument> storage;

	public StorageRepository() {
		storage = new HashMap<Long, MusicalInstrument>();

	}

	public boolean add(MusicalInstrument instrument) {
		if (storage.containsKey(instrument.getId())) {
			return false;
		}
		storage.put(instrument.getId(), instrument);
		return true;
	}

	public MusicalInstrument getProduct(long productId) {
		return storage.get(productId);
	}

	public Map<Long, MusicalInstrument> getAllProducts() {
//		TODO Think about seriallization unmodMap
//		return Collections.unmodifiableMap(storage);
		return storage;
	}

	public void initDefaultData() {
		storage.put(1L, new Guitar(1L, "ESP LTD EC1000", 1200, "Silver",
				"Redwood", 24));
		storage.put(2L,
				new Guitar(2L, "Cort X10", 400, "Bronze", "Redwood", 24));
		storage.put(3L, new Guitar(3L, "Charvel DC1", 800, "Silver", "Redwood",
				24));
		storage.put(4L, new Guitar(4L, "Cort EVL-K5", 400, "Bronze",
				"Canadian Maple", 24));
		storage.put(5L, new Guitar(5L, "Gibson Custom SG", 3700, "Silver",
				"Redwood", 22));
		storage.put(6L, new Guitar(6L, "Gibson Explorer", 2500, "Silver",
				"Redwood", 22));
		storage.put(7L, new Guitar(7L, "ESP Eclipse-II", 1800, "Silver",
				"Redwood", 24));
		storage.put(8L, new Guitar(8L, "Cort X1", 150, "Bronze", "Maple", 24));
	}

	public void setStorage(Map<Long, MusicalInstrument> storage) {
		this.storage = storage;
	}
}
