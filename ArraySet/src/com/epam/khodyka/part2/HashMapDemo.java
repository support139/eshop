package com.epam.khodyka.part2;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
	public static void main(String[] args) {

		Map<LenghtHashWrapper, MusicalInstrument> firstMap = new HashMap<>();
		firstMap.put(new LenghtHashWrapper("Hashcode"), new Guitar("EC1000",
				800, "Redwood", 24));
		firstMap.put(new LenghtHashWrapper("Hashcode"), new Guitar("CortX10",
				800, "Redwood", 24));
		firstMap.put(new LenghtHashWrapper("Hashcode"), new Guitar("CortM520",
				800, "Redwood", 22));
		firstMap.put(new LenghtHashWrapper("Hashcode"), new Guitar(
				"Gibson LesPaul", 800, "Blackwood", 22));

		Map<SumHashWrapper, MusicalInstrument> secondMap = new HashMap<>();
		secondMap.put(new SumHashWrapper("Hashcode"), new Guitar("EC1000", 800,
				"Redwood", 24));
		secondMap.put(new SumHashWrapper("Hashcode"), new Guitar("CortX10",
				800, "Redwood", 24));
		secondMap.put(new SumHashWrapper("Hashcode"), new Guitar("CortM520",
				800, "Redwood", 22));
		secondMap.put(new SumHashWrapper("Hashcode"), new Guitar(
				"Gibson LesPaul", 800, "Blackwood", 22));

		for (Map.Entry<LenghtHashWrapper, MusicalInstrument> entry : firstMap
				.entrySet()) {
			System.out.println(entry.getValue());
		}

		System.out.println();

		for (Map.Entry<SumHashWrapper, MusicalInstrument> entry : secondMap
				.entrySet()) {
			System.out.println(entry.getValue());
		}

	}
}
