package com.epam.khodyka.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.service.ServiceManager;

public class Seriallizer {

	public void save(Object object, int amount) {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream("Test.ser"))) {
			for (int i = 0; i < amount; i++) {
				objectOutputStream.writeObject(object);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveToGzip(Object object, int amount) {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new GZIPOutputStream(new FileOutputStream("Test.gzip")))) {
			for (int i = 0; i < amount; i++) {
				objectOutputStream.writeObject(object);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		ServiceManager manager = new ServiceManager();
		Map<Long, MusicalInstrument> map = manager.getStorageService()
				.getAllProduct();

		Seriallizer seriallizer = new Seriallizer();
		seriallizer.save(map, 200);
		seriallizer.saveToGzip(map, 200);
	}
}
