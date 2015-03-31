package com.epam.khodyka.part2.filter;

import java.io.File;

public abstract class Filter {
	private Filter nextFilter;

	public void addFilter(Filter nextFiler) {
		if (!hasNextFilter()) {
			this.nextFilter = nextFiler;
		} else {
			this.nextFilter.addFilter(nextFiler);
		}
	}

	public boolean hasNextFilter() {
		return nextFilter != null;
	}

	public boolean toNextFilter(File file) {
		return nextFilter.matches(file);
	}

	public abstract boolean matches(File file);
}
