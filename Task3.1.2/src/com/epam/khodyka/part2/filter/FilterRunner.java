package com.epam.khodyka.part2.filter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilterRunner {

	private Filter filter;
	private List<File> fileList;

	public FilterRunner() {
		this.fileList = new ArrayList<>();
	}

	public void addFilter(Filter filter) {
		if (this.filter == null) {
			this.filter = filter;
		} else {
			this.filter.addFilter(filter);
		}
	}

	public List<File> run(String rootDirectory) {
		File file = new File(rootDirectory);
		File[] files = file.listFiles();
		if (files != null) {
			for (File f : files) {
				processFile(f);
			}
		}
		return fileList;
	}

	private void processFile(File f) {
		if (f.isDirectory()) {
			run(f.getAbsolutePath());
		}
		useFilter(f);
	}
	
	private void useFilter(File f){
		if (f.isFile()) {
			if (filter.matches(f)) {
				fileList.add(f);
			}
		}
	}
}
