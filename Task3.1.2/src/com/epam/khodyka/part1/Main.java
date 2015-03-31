package com.epam.khodyka.part1;

import java.io.FileNotFoundException;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		TextWrapper wrapper = new TextWrapper("text.txt");
		Iterator<String> iter = wrapper.iterator();

		for (String s : wrapper) {
			System.out.println(s);
		}

		System.out.println(iter.hasNext());
		System.out.println(iter.next());
		System.out.println(iter.hasNext());
		System.out.println(iter.next());
		System.out.println(iter.hasNext());
		System.out.println(iter.next());
		System.out.println(iter.hasNext());
		System.out.println(iter.next());

	}
}
