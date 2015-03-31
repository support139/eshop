package com.epam.khodyka.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TextWrapper implements Iterable<String> {

	private String filename;

	public TextWrapper(String filename) {
		this.filename = filename;
	}

	@Override
	public Iterator<java.lang.String> iterator() {
		return new MyIterator<String>();
	}

	private class MyIterator<String> implements Iterator<String> {

		private Scanner scaner;

		public MyIterator() {
			try {
				this.scaner = new Scanner(new File(filename));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		@Override
		public boolean hasNext() {
			if (scaner.hasNextLine()) {
				return true;
			}
			scaner.close();
			return false;

		}

		@Override
		public String next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return (String)scaner.nextLine();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
