package com.epam.khodyka.part3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SequenceSearcher extends Thread {

	private Object sync;
	private Path path;
	private int maxLength;
	private int firstOccurrence;
	private int lastOccurrence;

	public SequenceSearcher(Object sync) {
		this.sync = sync;
	}

	public void setPath(String filename) {
		this.path = Paths.get(filename);
	}

	public int getMaxLength() {
		return maxLength;
	}

	@Override
	public void run() {
		synchronized (sync) {
			try {
				sync.wait();
			} catch (InterruptedException e) {
				System.err.println("Exception!");
			}
		}
		try {
			search();
		} catch (IOException e) {
			System.err.println("Exception!");
		}
	}

	private void search() throws IOException {
		byte[] bytes = Files.readAllBytes(path);
		for (int i = 0; i < bytes.length; i++) {
			for (int j = i + 1; j < bytes.length; j++) {
				if (bytes[i] == bytes[j]) {
					matcher(i, j, bytes);
				}
			}
		}
	}

	private void matcher(int i, int j, byte[] arr) {
		int tmpSequenceLength = 0;
		while (arr[i++] == arr[j++]) {
			tmpSequenceLength++;
			if (j == arr.length)
				break;
		}
		if (tmpSequenceLength > maxLength) {
			updateStatus(i, j, tmpSequenceLength);
		}
	}

	private void updateStatus(int i, int j, int tmpSequenceLength) {
		maxLength = tmpSequenceLength;
		firstOccurrence = i - maxLength;
		lastOccurrence = j - maxLength;
	}

	public void printInfo() {
		System.out.println("First occurrence: " + firstOccurrence);
		System.out.println("Last occurrence: " + lastOccurrence);
		System.out.println("Max length: " + maxLength);
	}

}
