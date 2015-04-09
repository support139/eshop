package com.epam.khodyka.part3;

import java.util.Scanner;

public class SearchRunner {

	private Scanner scanner;
	private Object sync;

	public SearchRunner(Object sync) {
		this.scanner = new Scanner(System.in);
		this.sync = sync;
	}

	public void startSearch() throws InterruptedException {
		while (true) {
			SequenceSearcher searcher = new SequenceSearcher(sync);
			searcher.start();
			String filename = readFilepath();
			searcher.setPath(filename);
			synchronized (sync) {
				sync.notifyAll();
			}
			while (searcher.isAlive()) {
				System.out.println("Current max length: "
						+ searcher.getMaxLength());
				Thread.sleep(50);
			}
			searcher.printInfo();
		}
	}

	private String readFilepath() {
		System.out.print(">");
		return scanner.nextLine();
	}

}
