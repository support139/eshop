package com.epam.khodyka.part1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.epam.khodyka.part1.ProtectedIteratorList;

public class ProtectedIteratorListTest {

	private ProtectedIteratorList<String> list;
	private String originalString;

	@Before
	public void setup() {
		list = new ProtectedIteratorList<String>();
		list.add("One");
		list.add("Two");
		list.add("Three");

		originalString = "One Two Three";
	}

	@Test
	public void resultShouldBeEqualToOriginalDataWhenAddingNewElement() {
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s + " ");
			list.add("gg");
		}
		assertEquals(originalString, sb.toString().trim());
	}

	@Test
	public void resultShouldBeEqualToOriginalDataWhenAddingFewNewElements() {
		StringBuilder sb = new StringBuilder();
		List<String> tmpList = new ArrayList<>();
		tmpList.add("qwe");
		tmpList.add("rty");
		for (String s : list) {
			sb.append(s + " ");
			list.addAll(tmpList);
		}
		assertEquals(originalString, sb.toString().trim());
	}

	@Test
	public void resultShouldBeEqualToOriginalDataWhenChangingSomeElement() {
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s + " ");
			list.set(1, "gg");
		}
		assertEquals(originalString, sb.toString().trim());
	}

	@Test
	public void resultShouldBeEqualToOriginalDataWhenRemovingSomeElement() {
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s + " ");
			list.remove("One");
		}
		assertEquals(originalString, sb.toString().trim());
	}

	@Test
	public void resultShouldBeEqualToOriginalDataWhenRemovingFewElements() {
		StringBuilder sb = new StringBuilder();
		List<String> tmpList = new ArrayList<>();
		tmpList.add("One");
		tmpList.add("Two");
		for (String s : list) {
			sb.append(s + " ");
			list.removeAll(tmpList);
		}
		assertEquals(originalString, sb.toString().trim());
	}

	@Test
	public void resultShouldBeEqualToOriginalDataWhenRetainingFewElements() {
		StringBuilder sb = new StringBuilder();
		List<String> tmpList = new ArrayList<>();
		tmpList.add("One");
		tmpList.add("Two");
		for (String s : list) {
			sb.append(s + " ");
			list.retainAll(tmpList);
		}
		assertEquals(originalString, sb.toString().trim());
	}

}
