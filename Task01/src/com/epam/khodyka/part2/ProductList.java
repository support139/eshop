package com.epam.khodyka.part2;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import com.epam.khodyka.part1.MusicalInstruments;

public class ProductList<E extends MusicalInstruments> implements List<E> {

	private static final int DEFAULT_INITIAL_CAPACITY = 10;

	private Object[] array;
	private int size;
	private int modCount;

	public ProductList() {
		array = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public ProductList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException();
		}
		array = new Object[initialCapacity];
	}

	@Override
	public boolean add(E e) {
		add(size, e);
		return true;
	}

	@Override
	public void add(int index, E element) {
		addRangeCheck(index);
		if (!capacityCheck()) {
			increase();
		}
		int toMove = size - index;
		System.arraycopy(array, index, array, index + 1, toMove);
		array[index] = element;
		size++;
		modCount++;
	}

	@Override
	public boolean remove(Object o) {
		for (int i = 0; i < size; i++) {
			if (Objects.deepEquals(o, array[i])) {
				fastRemove(i);
				modCount++;
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		rangeCheck(index);
		Object oldValue = array[index];
		fastRemove(index);
		modCount++;
		return (E) oldValue;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		int previousModCount = modCount;
		for (Object o : c) {
			while (contains(o)) {
				remove(o);
			}
		}
		return previousModCount != modCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		rangeCheck(index);
		return (E) array[index];
	}

	@Override
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!contains(o)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		modCount++;
		return addAll(size, c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		addRangeCheck(index);
		while (size + index + c.size() > array.length) {
			increase();
		}
		Object[] tmp = c.toArray();
		System.arraycopy(array, index, array, index + tmp.length, tmp.length);
		System.arraycopy(tmp, 0, array, index, tmp.length);
		size += tmp.length;
		modCount++;
		return tmp.length != 0;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		int previousModCount = modCount;
		for (Object o : array) {
			while (!c.contains(o) && contains(o)) {
				remove(o);
			}
		}
		return previousModCount != modCount;
	}

	@Override
	public void clear() {
		Arrays.fill(array, null);
		size = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, E element) {
		rangeCheck(index);
		Object oldValue = array[index];
		array[index] = element;
		modCount++;
		return (E) oldValue;

	}

	@Override
	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (Objects.deepEquals(array[i], o)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if (Objects.deepEquals(array[i], o)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		int subArraySize = toIndex - fromIndex;
		Object[] subArray = new Object[subArraySize];
		System.arraycopy(array, fromIndex, subArray, 0, subArraySize);
		return (List) Arrays.asList(subArray);
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			private int cursor;
			private int currentModCount = modCount;

			@Override
			public boolean hasNext() {
				return cursor != size;
			}

			@SuppressWarnings("unchecked")
			@Override
			public E next() {
				checkForModification(currentModCount);
				if (cursor >= size) {
					throw new NoSuchElementException();
				}
				return (E) array[cursor++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public Iterator<E> filterIterator(final Predicate predicate) {
		return new Iterator<E>() {

			final Predicate pred = predicate;
			private Iterator<E> iter = iterator();
			private Object nextObject;
			private boolean hasNextObject;

			@Override
			public boolean hasNext() {
				if (hasNextObject) {
					return true;
				} else {
					return setNextObject();
				}
			}

			@SuppressWarnings("unchecked")
			@Override
			public E next() {
				if (!hasNextObject) {
					if (!setNextObject()) {
						throw new NoSuchElementException();
					}
				}
				hasNextObject = false;
				return (E) nextObject;
			}

			public boolean setNextObject() {
				while (iter.hasNext()) {
					Object tmp = iter.next();
					if (pred.test(tmp)) {
						nextObject = tmp;
						hasNextObject = true;
						return true;
					}
				}
				return false;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			return (T[]) Arrays.copyOf(array, size, a.getClass());
		}
		System.arraycopy(array, 0, a, 0, size);
		if (a.length > size) {
			a[size] = null;
		}
		return a;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size != 0;
	}

	private void increase() {
		Object[] tmp = new Object[array.length];
		System.arraycopy(array, 0, tmp, 0, array.length);
		int newSize = array.length * 2;
		array = new Object[newSize];
		System.arraycopy(tmp, 0, array, 0, tmp.length);
	}

	private void fastRemove(int index) {
		int toMove = array.length - index - 1;
		System.arraycopy(array, index + 1, array, index, toMove);
		array[--size] = null;
	}

	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}

	private void addRangeCheck(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
	}

	private boolean capacityCheck() {
		return size != array.length;
	}

	private void checkForModification(int currentModCount) {
		if (modCount != currentModCount) {
			throw new ConcurrentModificationException();
		}
	}
}
