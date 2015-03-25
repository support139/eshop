package com.epam.khodyka.service;

import java.util.Map;

import com.epam.khodyka.db.StorageRepository;
import com.epam.khodyka.db.entity.MusicalInstrument;

public class StorageService {

	private StorageRepository storageRepository;

	public StorageService(StorageRepository storageRepository) {
		this.storageRepository = storageRepository;
	}

	public Map<Long, MusicalInstrument> getAllProduct() {
		return storageRepository.getAllProducts();
	}

	public MusicalInstrument getProductById(long productId) {
		return storageRepository.getProduct(productId);
	}
}
