package com.epam.khodyka.part2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.epam.khodyka.part1.Guitar;
import com.epam.khodyka.part1.MusicalInstruments;
import com.epam.khodyka.part1.Percussion;

public class MyListTest {

	private ProductList<MusicalInstruments> myList;
	private Guitar guitar;

	@Before
	public void createList() {
		myList = new ProductList<>();
		guitar = new Guitar("gg", 12, "wp", "qq", "redwood", 24);
	}

	@Test
	public void sizeShouldBeEqualsOneWhenAddNewValue() {
		myList.add(guitar);
		assertTrue(myList.size() == 1);
	}

	@Test
	public void sizeShouldBeEqualsOneWhenAddNull() {
		myList.add(null);
		assertTrue(myList.size() == 1);
	}

	@Test
	public void receivedObjectOfTheIndexShouldBeSameAsAdding() {
		myList.add(guitar);
		MusicalInstruments guitar = myList.get(0);
		assertTrue(guitar.equals(guitar));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldThrowExceptionWhenAddingAbroad() {
		myList.add(5, guitar);
	}

	@Test
	public void receivedObjectShouldNotBeNullWhenGettingNotNullValue() {
		myList.add(guitar);
		MusicalInstruments guitar = myList.get(0);
		assertNotNull(guitar);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldThrowExceptionWhenGettingAbroad() {
		myList.get(5);
	}

	@Test
	public void shouldBeTrueWhenGettingNullValue() {
		myList.add(null);
		MusicalInstruments guitar = myList.get(0);
		assertNull(guitar);
	}

	@Test
	public void sizeShouldBeEqualsOneWhenRemovingOneValue() {
		myList.add(guitar);
		myList.add(new Guitar());
		myList.remove(guitar);
		assertTrue(myList.size() == 1);
	}

	@Test
	public void shouldBeFalseWhenRemovingNotExistValue() {
		boolean condition = myList.remove(guitar);
		assertFalse(condition);
	}

	@Test
	public void shouldBeTrueWhenRemovingNullValue() {
		myList.add(null);
		boolean condition = myList.remove(null);
		assertTrue(condition);
	}

	@Test
	public void sizeShouldBeEqualsOneWhenRemovingFromPosition() {
		myList.add(guitar);
		myList.add(guitar);
		myList.remove(0);
		assertTrue(myList.size() == 1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldThrowExceptionWhenRemovingAbroad() {
		myList.remove(2);
	}

	@Test
	public void sizeShouldBeEqualsOneWhenRemovingAllElements() {
		myList.add(guitar);
		myList.add(guitar);
		myList.add(new Percussion());

		ProductList<MusicalInstruments> tmpList = new ProductList<MusicalInstruments>();
		tmpList.add(guitar);
		myList.removeAll(tmpList);
		assertTrue(myList.size() == 1);
	}

	@Test
	public void shouldBeTrueWhenRemovingAtLeastOneElement() {
		myList.add(guitar);
		myList.add(guitar);
		myList.add(new Percussion());

		ProductList<MusicalInstruments> tmpList = new ProductList<MusicalInstruments>();
		tmpList.add(guitar);
		assertTrue(myList.removeAll(tmpList));
	}

	@Test
	public void shouldBeFalseWhenRemovingNotExistValues() {
		myList.add(new Percussion());
		myList.add(new Percussion());

		ProductList<MusicalInstruments> tmpList = new ProductList<MusicalInstruments>();
		tmpList.add(guitar);
		assertTrue(myList.size() == 2);
		assertFalse(myList.removeAll(tmpList));
	}

	@Test
	public void indexShouldBeEqualsZeroWhenIndexIsZero() {
		myList.add(guitar);
		assertTrue(myList.indexOf(guitar) == 0);
	}

	@Test
	public void indexOfNullValueShouldBeEqualsZero() {
		myList.add(null);
		assertTrue(myList.indexOf(null) == 0);
	}

	@Test
	public void indexOfNotExistValueShouldBeEqualsMinusOne() {
		assertTrue(myList.indexOf(guitar) == -1);
	}

	@Test
	public void shouldBeTrueWhenValueExists() {
		myList.add(guitar);
		assertTrue(myList.contains(guitar));
	}

	@Test
	public void shouldBeFalseWhenValueNotExist() {
		assertFalse(myList.contains(guitar));
	}

	@Test
	public void shouldBeTrueWhenNullValueExist() {
		myList.add(null);
		assertTrue(myList.contains(null));
	}

	@Test
	public void shouldBeTrueWhenAddingAtEnd() {
		myList.add(new Percussion());
		myList.add(guitar);

		ProductList<MusicalInstruments> tmpList = new ProductList<MusicalInstruments>();
		tmpList.add(new Percussion());
		tmpList.add(guitar);
		assertTrue(myList.containsAll(tmpList));
	}

	@Test
	public void shouldBeFalseWhenAddingAbroad() {
		myList.add(new Percussion());

		ProductList<MusicalInstruments> tmpList = new ProductList<MusicalInstruments>();
		tmpList.add(new Percussion());
		tmpList.add(guitar);
		assertFalse(myList.containsAll(tmpList));
	}
}
