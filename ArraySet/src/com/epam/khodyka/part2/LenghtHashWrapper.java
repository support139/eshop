package com.epam.khodyka.part2;

public class LenghtHashWrapper {
	private String str;

	public LenghtHashWrapper(String str) {
		this.str = str;
	}

	@Override
	public int hashCode() {
		return str.length();
	}
}
