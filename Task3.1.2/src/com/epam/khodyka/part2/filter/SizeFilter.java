package com.epam.khodyka.part2.filter;

import java.io.File;

public class SizeFilter extends Filter {

	private long from;
	private long to;

	public SizeFilter(long from, long to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public boolean matches(File file) {
		if (file.length() > from && file.length() < to) {
			if (hasNextFilter()) {
				return toNextFilter(file);
			}
			return true;
		}
		return false;
	}

}
