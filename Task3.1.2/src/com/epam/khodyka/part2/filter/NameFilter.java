package com.epam.khodyka.part2.filter;

import java.io.File;

public class NameFilter extends Filter {

	private String name;

	public NameFilter(String name) {
		this.name = name;
	}

	@Override
	public boolean matches(File file) {
		if (file.getName().startsWith(name)) {
			if (hasNextFilter()) {
				return toNextFilter(file);
			}
			return true;
		}
		return false;
	}
}
