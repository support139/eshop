package com.epam.khodyka.part3;

public class Main {
	public static void main(String[] args) {

		SearchRunner runner = new SearchRunner(new Object());
		try {
			runner.startSearch();
		} catch (InterruptedException e) {
			System.err.println("Exception!");
		}
	}
}
