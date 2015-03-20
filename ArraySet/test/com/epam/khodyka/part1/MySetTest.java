package com.epam.khodyka.part1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MySetTest {

	private MySet<String> set;

	@Before
	public void setup() {
		set = new MySet<>();
		set.add("One");
		set.add("Two");
	}

	@Test
	public void shouldBeFalseWhenAddingAlreadyExistingElement() {
		assertFalse(set.add("One"));
	}

	@Test
	public void shouldBeTrueWhenAddingNotExistingElement() {
		assertTrue(set.add("Three"));
	}

	@Test
	public void shouldBeFalseWhenAddingAtLeastOneExistingElement() {
		MySet<String> tmpSet = new MySet<>();
		tmpSet.add("One");
		tmpSet.add("Five");
		assertFalse(set.addAll(tmpSet));
	}

	@Test
	public void shouldBeTrueWhenAddingAllNotExistingElement() {
		MySet<String> tmpSet = new MySet<>();
		tmpSet.add("Three");
		tmpSet.add("Four");
		assertTrue(set.addAll(tmpSet));
	}

	@Test
	public void shouldBeFalseWhenAddingFewExistingElements() {
		MySet<String> tmpSet = new MySet<>();
		tmpSet.add("One");
		tmpSet.add("Two");
		assertFalse(set.addAll(1, tmpSet));
	}

	@Test
	public void shouldBeTrueWhenAddingFewNotExistingElements() {
		MySet<String> tmpSet = new MySet<>();
		tmpSet.add("Three");
		tmpSet.add("Four");
		assertTrue(set.addAll(1, tmpSet));
	}
}
