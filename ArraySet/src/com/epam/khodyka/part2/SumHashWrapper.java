package com.epam.khodyka.part2;

public class SumHashWrapper {
	private String str;

	public SumHashWrapper(String str) {
		this.str = str;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		for (int i = 0; i < str.length() && i < 4; i++) {
			hash += str.charAt(i);
		}
		return hash;
	}
}
