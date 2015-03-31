package com.epam.khodyka.part2.filter;

import java.io.File;

public class ExtensionFilter extends Filter {

	private String extension;

	public ExtensionFilter(String extension) {
		this.extension = extension;
	}

	@Override
	public boolean matches(File file) {
		if (getExtension(file.getName()).equals(extension)) {
			if (hasNextFilter()) {
				return toNextFilter(file);
			}
			return true;
		}
		return false;
	}

	private String getExtension(String filename) {
		return filename.substring(filename.indexOf('.') + 1, filename.length());
	}
}
