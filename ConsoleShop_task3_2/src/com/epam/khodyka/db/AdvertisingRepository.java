package com.epam.khodyka.db;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import com.epam.khodyka.db.entity.MusicalInstrument;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class AdvertisingRepository {
	private Map<Long, MusicalInstrument> advertising = new LinkedHashMap<>(16,
			0.75f, true);

	public void add(long key, MusicalInstrument instrument) {
		advertising.put(key, instrument);
	}

	public Map<Long, MusicalInstrument> getAll() {
		return Collections.unmodifiableMap(advertising);
	}
}
