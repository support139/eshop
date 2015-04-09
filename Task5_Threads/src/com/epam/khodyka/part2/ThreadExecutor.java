package com.epam.khodyka.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.epam.khodyka.part1.MyThread;

public class ThreadExecutor {
	public static void main(String[] args) throws InterruptedException {

		List<Integer> totalSimple = new ArrayList<>();

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

			ExecutorService executorService = Executors.newFixedThreadPool(4);

			for (int i = 0; i < threadAmount; i++) {
				from = i * rangeForOneThread + 1;
				actualTo += rangeForOneThread;
				executorService.execute(new MyThread(from, actualTo,
						totalSimple));
			}

			executorService.shutdown();
			executorService.awaitTermination(10, TimeUnit.SECONDS);
			System.out.println(totalSimple);
		}
	}
}
