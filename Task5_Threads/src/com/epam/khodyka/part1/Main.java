package com.epam.khodyka.part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		List<Integer> totalSimple = new ArrayList<>();
		List<Thread> threads = new ArrayList<>();

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter range. From: ");
			int from = Integer.valueOf(scanner.nextLine());
			System.out.println("Enter range. To: ");
			int to = Integer.valueOf(scanner.nextLine());
			System.out.println("Enter amount of threads: ");
			int threadAmount = Integer.valueOf(scanner.nextLine());

			int numbersInRange = to - from + 1;
			int rangeForOneThread = numbersInRange / threadAmount;
			int actualTo = 0;

			for (int i = 0; i < threadAmount; i++) {
				from = i * rangeForOneThread + 1;
				actualTo += rangeForOneThread;
				Thread thread = new MyThread(from, actualTo, totalSimple);
				threads.add(thread);
				thread.start();
			}
			for (Thread t : threads) {
				t.join();
			}
			Collections.sort(totalSimple);
			System.out.println(totalSimple);
		}
	}
}
