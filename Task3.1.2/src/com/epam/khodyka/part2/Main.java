package com.epam.khodyka.part2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.epam.khodyka.part2.filter.DateFilter;
import com.epam.khodyka.part2.filter.ExtensionFilter;
import com.epam.khodyka.part2.filter.FilterRunner;
import com.epam.khodyka.part2.filter.NameFilter;
import com.epam.khodyka.part2.filter.SizeFilter;

public class Main {
	public static void main(String[] args) {
		int choose = -1;

		List<File> files = new ArrayList<>();

		try (Scanner scanner = new Scanner(System.in)) {
			FilterRunner filterRunner = new FilterRunner();

			System.out.println("1. Use filename");
			System.out.println("2. Use extension");
			System.out.println("3. Use date");
			System.out.println("4. Use size");
			System.out.println("5. Start search");
			System.out.println("0. Exit");

			while (choose != 0) {
				System.out.print("You chose: ");
				choose = Integer.valueOf(scanner.nextLine());
				switch (choose) {
				case 1:
					System.out.println("Enter filename: ");
					String filename = scanner.nextLine();
					filterRunner.addFilter(new NameFilter(filename));
					break;
				case 2:
					System.out.print("Enter extension: ");
					String extension = scanner.nextLine();
					filterRunner.addFilter(new ExtensionFilter(extension));
					break;
				case 3:
					System.out.print("Enter from: ");
					String dateFrom = scanner.nextLine();
					System.out.print("Enter to: ");
					String dateTo = scanner.nextLine();
					filterRunner.addFilter(new DateFilter(dateFrom, dateTo));
					break;
				case 4:
					System.out.print("Enter min size (bytes): ");
					long sizeFrom = Long.valueOf(scanner.nextLine());
					System.out.print("Enter max size (bytes): ");
					long sizeTo = Long.valueOf(scanner.nextLine());
					filterRunner.addFilter(new SizeFilter(sizeFrom, sizeTo));
					break;

				case 5:
					System.out.println("Enter directory path: ");
					String rootDirectory = scanner.nextLine();
					files = filterRunner.run(rootDirectory);
					filterRunner = new FilterRunner();
					break;
				}
			}
		}
		System.out.println(files.size());
		System.out.println("Done...");
	}
}
