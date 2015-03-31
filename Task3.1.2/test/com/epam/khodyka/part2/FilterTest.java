package com.epam.khodyka.part2;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.epam.khodyka.part2.filter.DateFilter;
import com.epam.khodyka.part2.filter.ExtensionFilter;
import com.epam.khodyka.part2.filter.FilterRunner;
import com.epam.khodyka.part2.filter.NameFilter;
import com.epam.khodyka.part2.filter.SizeFilter;

public class FilterTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Before
	public void setup() throws IOException {
		folder.newFolder("/files");
		folder.newFolder("/files/1");
		folder.newFolder("/files/1/2");
		folder.newFolder("/files/1/2/1");

		folder.newFile("/files/q.txt");
		folder.newFile("/files/1/w.txt");
		folder.newFile("/files/1/2/r.txt");
		folder.newFile("/files/1/2/1/t.txt");
	}

	private List<String> getSimpleFileName(List<File> files) {
		List<String> fileNames = new ArrayList<String>();
		for (File file : files) {
			fileNames.add(file.getName());
		}
		return fileNames;
	}

	@Test
	public void listShouldContainFilesWhenUsingExtensionFilter() {
		FilterRunner runner = new FilterRunner();
		runner.addFilter(new ExtensionFilter("txt"));
		List<File> fileList = runner.run(folder.getRoot().toString());
		assertEquals("[t.txt, r.txt, w.txt, q.txt]",
				getSimpleFileName(fileList).toString());
	}

	@Test
	public void listShouldContainFilesWhenUsingDateFilter() {
		FilterRunner runner = new FilterRunner();
		runner.addFilter(new DateFilter("20.03.2015", "20.04.2015"));
		List<File> fileList = runner.run(folder.getRoot().toString());
		assertEquals("[t.txt, r.txt, w.txt, q.txt]",
				getSimpleFileName(fileList).toString());

	}

	@Test
	public void listShouldContainFileWhenUsingNameFilter() {
		FilterRunner runner = new FilterRunner();
		runner.addFilter(new NameFilter("q"));
		List<File> fileList = runner.run(folder.getRoot().toString());
		assertEquals("[q.txt]", getSimpleFileName(fileList).toString());

	}

	@Test
	public void listShouldContainFilesWhenUsingSizeFilter() {
		FilterRunner runner = new FilterRunner();
		runner.addFilter(new SizeFilter(-1, 100_000_000));
		List<File> fileList = runner.run(folder.getRoot().toString());
		assertEquals("[t.txt, r.txt, w.txt, q.txt]",
				getSimpleFileName(fileList).toString());
	}

	@Test
	public void listShouldContainFilesWhenUsingAllFilters() {
		FilterRunner runner = new FilterRunner();
		runner.addFilter(new DateFilter("20.03.2015", "20.04.2015"));
		runner.addFilter(new NameFilter("q"));
		runner.addFilter(new DateFilter("20.03.2015", "20.04.2015"));
		runner.addFilter(new SizeFilter(-1, 1000000));
		List<File> fileList = runner.run(folder.getRoot().toString());
		assertEquals("[q.txt]", getSimpleFileName(fileList).toString());

	}

}
