package com.epam.khodyka.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.epam.khodyka.db.StorageRepository;
import com.epam.khodyka.db.entity.MusicalInstrument;

public class StorageService {

	private StorageRepository storageRepository;

	public StorageService(StorageRepository storageRepository) {
		this.storageRepository = storageRepository;
	}

	public boolean addProduct(MusicalInstrument instrument) {
		return storageRepository.add(instrument);
	}

	public Map<Long, MusicalInstrument> getAllProduct() {
		return storageRepository.getAllProducts();
	}

	public MusicalInstrument getProductById(long productId) {
		return storageRepository.getProduct(productId);
	}

	public void save() {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream("Storage.ser"))) {
			objectOutputStream.writeObject(storageRepository.getAllProducts());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void load() {
		try (ObjectInputStream objectInputStream = new ObjectInputStream(
				new FileInputStream("Storage.ser"))) {
			Map<Long, MusicalInstrument> loadedStorage = (Map<Long, MusicalInstrument>) objectInputStream
					.readObject();
			storageRepository.setStorage(loadedStorage);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
