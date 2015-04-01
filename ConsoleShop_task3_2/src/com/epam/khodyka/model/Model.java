package com.epam.khodyka.model;

import java.util.HashMap;
import java.util.Map;

public class Model {

	private Map<String, Object> model = new HashMap<>();

	public void put(String key, Object value) {
		model.put(key, value);
	}

	public Object get(String key) {
		return model.get(key);
	}

}
