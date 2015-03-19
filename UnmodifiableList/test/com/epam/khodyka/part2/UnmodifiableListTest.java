package com.epam.khodyka.part2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UnmodifiableListTest {

	private ArrayList<String> unmodList;
	private ArrayList<String> modList;
	private UnmodifiableList<String> list;

	@Before
	public void setup() {
		unmodList = new ArrayList<String>();
		unmodList.add("One");
		unmodList.add("Two");
		unmodList.add("Three");
		unmodList.add("Four");
		unmodList.add("Five");

		modList = new ArrayList<String>();
		modList.add("Six");
		modList.add("Seven");
		modList.add("Eight");
		modList.add("Nine");
		modList.add("Ten");

		list = new UnmodifiableList<>(unmodList, modList);
	}

	@Test
	public void sizeShouldBeEqualTenWhenTenElementAdded() {
		assertTrue(list.size() == 10);
	}

	@Test
	public void sizeShouldNotBeEqualZeroWhenCollectionIsNotEmpty() {
		assertTrue(list.size() != 0);
	}

	@Test
	public void unmodifiablePartShouldContainAddedElement() {
		String value = "Two";
		assertTrue(list.contains(value));
	}

	@Test
	public void modifiablePartShouldContainAddedElement() {
		String value = "Nine";
		assertTrue(list.contains(value));
	}

	@Test
	public void shouldBeTrueWhenAddingNewElement() {
		String value = "Eleven";
		assertTrue(list.add(value));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void shouldThrowEcxeptionWhenAddingAtUnmodPart() {
		String value = "Nine";
		list.add(2, value);
	}

	@Test
	public void receivedValueFromUnmodPartShouldBeEqualAddingElement() {
		String value = "Three";
		assertNotNull(value.equals(list.get(2)));
	}

	@Test
	public void receivedValueFromModPartShouldBeEqualAddingElement() {
		String value = "Nine";
		assertNotNull(value.equals(list.get(8)));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void shouldThrowExceptionWhenTryToSetValueAtUnmodPart() {
		String value = "test";
		list.set(2, value);
	}

	@Test
	public void receivedValueShouldBeEqualToChangedValue() {
		String value = "test";
		list.set(7, value);
		assertEquals(list.get(7), value);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void shouldThrowExcepionWhenRemovingFromUnmodPart() {
		list.remove(3);
	}

	@Test
	public void shouldReceiveValueFromModPartWhenRemoving() {
		assertNotNull(list.remove(6));
	}

	@Test
	public void sizeShouldBeEqualNineWhenRemovingFromModPart() {
		list.remove(6);
		assertTrue(list.size() == 9);
	}

	@Test
	public void indexOfElementFromModPartShouldBeEqualEight() {
		int index = list.indexOf("Nine");
		assertTrue(index == 8);
	}

	@Test
	public void indexOfElementFromUnmodPartShouldBeEqualTwo() {
		int index = list.indexOf("Three");
		assertTrue(index == 2);
	}

	@Test
	public void indexOfNotExistValueShouldBeEqualMinusOne() {
		int index = list.indexOf("blabla");
		assertTrue(index == -1);
	}

	@Test
	public void sizeOfReceivedArrayShouldBeEqualTwenty() {
		Object[] arr = list.toArray();
		assertTrue(arr.length == 10);
	}

	@Test
	public void listShouldContainAllElement() {
		assertTrue(list.containsAll(modList));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void shouldThrowExceptionWhenAddingListToUnmodPart() {
		list.addAll(2, modList);
	}

	@Test
	public void shouldBeTrueWhenAddingListToModPart() {
		assertTrue(list.addAll(modList));
	}

	@Test
	public void shouldBeTrueWhenRemovingFromModPart() {
		assertTrue(list.removeAll(modList));
	}

}
