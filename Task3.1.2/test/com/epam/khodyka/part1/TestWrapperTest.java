package com.epam.khodyka.part1;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TestWrapperTest {

	private String expectedText;
	private TextWrapper wrapper;
	public TemporaryFolder folder = new TemporaryFolder();

	@Before
	public void setup() {
		try {
			folder.create();
			File file = folder.newFile("test.txt");
			FileOutputStream stream = new FileOutputStream(file);
			stream.write("gggg".getBytes());
			stream.write(System.lineSeparator().getBytes());
			stream.write("qqqq".getBytes());
			stream.write(System.lineSeparator().getBytes());
			stream.write("wwww".getBytes());
			expectedText = "ggggqqqqwwww";
			wrapper = new TextWrapper(file.getAbsolutePath());
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void actualTextShouldBeEqualExpectedText() {
		StringBuilder actualText = new StringBuilder();
		for (String s : wrapper) {
			System.out.println(s);
			actualText.append(s);
		}
		assertEquals(expectedText, actualText.toString());

	}

	@Test(expected = NoSuchElementException.class)
	public void shouldThrowExceptionWhenNoHaveSuchElement() {
		Iterator<String> iter = wrapper.iterator();
		iter.next();
		iter.next();
		iter.next();
		iter.next();
	}

}
