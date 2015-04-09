package com.epam.khodyka.part1;

import java.util.ArrayList;
import java.util.List;

public class MyThread extends Thread {

	private int from;
	private int to;
	private List<Integer> localSimple;
	private List<Integer> totalSimple;

	public MyThread(int from, int to, List<Integer> totalSimple) {
		this.from = from;
		this.to = to;
		this.localSimple = new ArrayList<Integer>();
		this.totalSimple = totalSimple;
	}

	@Override
	public void run() {
		for (int i = from; i <= to; i++) {
			if (isSimple(i)) {
				localSimple.add(i);
			}
		}
		totalSimple.addAll(localSimple);
	}

	private boolean isSimple(int value) {
		for (int i = 2; i <= value / 2; i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}

}
