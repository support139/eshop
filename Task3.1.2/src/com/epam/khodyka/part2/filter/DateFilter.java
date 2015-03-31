package com.epam.khodyka.part2.filter;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFilter extends Filter {

	private String from;
	private String to;

	public DateFilter(String from, String to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public boolean matches(File file) {
		if (file.lastModified() > toDate(from)
				&& file.lastModified() < toDate(to)) {
			if (hasNextFilter()) {
				return toNextFilter(file);
			}
			return true;
		}
		return false;
	}

	private long toDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		try {
			return format.parse(date).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
