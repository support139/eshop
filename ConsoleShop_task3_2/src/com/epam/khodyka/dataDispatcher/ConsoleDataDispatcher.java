package com.epam.khodyka.datadispatcher;

import java.util.Scanner;

public class ConsoleDataDispatcher implements DataDispatcher {

	private Scanner scanner;

	public ConsoleDataDispatcher() {
		scanner = new Scanner(System.in);
	}

	@Override
	public String getStringData(String message) {
		System.out.println(message);
		return scanner.nextLine();
	}

	@Override
	public int getIntData(String message) {
		System.out.println(message);
		return Integer.valueOf(scanner.nextLine());
	}

	@Override
	public long getLongData(String message) {
		System.out.println(message);
		return Long.valueOf(scanner.nextLine());
	}

	@Override
	public double getDoubleData(String message) {
		System.out.println(message);
		return Double.valueOf(scanner.nextLine());
	}
}
