package com.epam.khodyka.dataDispatcher;

import java.util.Random;

public class RandomDataDispatcher implements DataDispatcher {

	private Random rand;

	public RandomDataDispatcher() {
		this.rand = new Random();
	}

	@Override
	public int getIntData(String message) {
		return rand.nextInt();
	}

	@Override
	public long getLongData(String message) {
		return rand.nextLong();
	}

	@Override
	public double getDoubleData(String message) {
		return rand.nextDouble();
	}

	@Override
	public String getStringData(String message) {
		return String.valueOf(rand.nextInt());
	}

}
