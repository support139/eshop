package com.epam.khodyka.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.khodyka.db.AdvertisingRepository;
import com.epam.khodyka.db.StorageRepository;
import com.epam.khodyka.db.entity.MusicalInstrument;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class AdvertisingService {

	private AdvertisingRepository advertisingRepository;
	private StorageRepository storageRepository;

	public AdvertisingService(AdvertisingRepository advertisingRepository,
			StorageRepository storageRepository) {
		this.advertisingRepository = advertisingRepository;
		this.storageRepository = storageRepository;
	}

	public void add(long key, MusicalInstrument instrument) {
		advertisingRepository.add(key, instrument);
	}

	public List<MusicalInstrument> getTheLatestFivePurchases() {
		Map<Long, MusicalInstrument> map = advertisingRepository.getAll();
		List<MusicalInstrument> list = new ArrayList<>();
		for (Map.Entry<Long, MusicalInstrument> entry : map.entrySet()) {
			list.add(storageRepository.getProduct(entry.getKey()));
		}
		return list;
	}
}
