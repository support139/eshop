package com.epam.khodyka.part2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class UnmodifiableList<E> implements List<E> {

	private List<E> unmodList;
	private List<E> modList;

	public UnmodifiableList(List<E> unmodList, List<E> modList) {
		this.unmodList = unmodList;
		this.modList = modList;
	}

	@Override
	public int size() {
		return unmodList.size() + modList.size();
	}

	@Override
	public boolean isEmpty() {
		return unmodList.size() == 0 && modList.size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		return unmodList.contains(o) || modList.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			private Iterator<E> unmodIter = unmodList.iterator();
			private Iterator<E> modIter = modList.iterator();

			@Override
			public boolean hasNext() {
				return unmodIter.hasNext() || modIter.hasNext();
			}

			@Override
			public E next() {
				if (unmodIter.hasNext()) {
					return unmodIter.next();
				} else if (modIter.hasNext()) {
					return modIter.next();
				} else {
					throw new NoSuchElementException();
				}
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public Object[] toArray() {
		int size = unmodList.size() + modList.size();
		Object[] tmp = new Object[size];
		System.arraycopy(unmodList.toArray(), 0, tmp, 0, unmodList.size());
		System.arraycopy(modList.toArray(), 0, tmp, unmodList.size(),
				modList.size());
		return tmp;

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		int size = unmodList.size() + modList.size();
		Object[] array = toArray();
		if (a.length < size) {
			return (T[]) Arrays.copyOf(array, size, a.getClass());
		}
		return setNullLastElement(size, array, a);
	}

	private <T> T[] setNullLastElement(int size, Object[] array, T[] a) {
		System.arraycopy(array, 0, a, 0, size);
		if (a.length > size) {
			a[size] = null;
		}
		return a;
	}

	@Override
	public boolean add(E e) {
		return modList.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return modList.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		Object[] tmp = toArray();
		int sizeOfCol = c.size();
		for (Object o : c) {
			for (Object o1 : tmp) {
				if (Objects.deepEquals(o, o1)) {
					sizeOfCol--;
				}
			}
		}
		return sizeOfCol <= 0;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return modList.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		if (isModifiableList(index)) {
			int actualIndex = getModifiablePartIndex(index);
			return modList.addAll(actualIndex, c);
		} else {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return modList.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return modList.retainAll(c);
	}

	@Override
	public void clear() {
		modList.clear();
	}

	@Override
	public E get(int index) {
		if (isModifiableList(index)) {
			int actualIndex = getModifiablePartIndex(index);
			return modList.get(actualIndex);
		} else {
			return unmodList.get(index);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, E element) {
		if (isModifiableList(index)) {
			int actualIndex = getModifiablePartIndex(index);
			Object oldValue = modList.get(actualIndex);
			modList.set(actualIndex, element);
			return (E) oldValue;
		} else {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public void add(int index, E element) {
		if (isModifiableList(index)) {
			int actualIndex = getModifiablePartIndex(index);
			modList.add(actualIndex, element);
		} else {
			throw new UnsupportedOperationException();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if (isModifiableList(index)) {
			int actualIndex = getModifiablePartIndex(index);
			Object oldValue = modList.get(actualIndex);
			modList.remove(actualIndex);
			return (E) oldValue;
		} else {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public int indexOf(Object o) {
		int index = unmodList.indexOf(o);
		if (index != -1) {
			return index;
		}
		index = modList.indexOf(o);
		if (index == -1) {
			return index;
		}
		return index + unmodList.size();

	}

	@Override
	public int lastIndexOf(Object o) {
		int index = unmodList.lastIndexOf(o);
		if (index != -1) {
			return index;
		}
		index = modList.lastIndexOf(o);
		if (index == -1) {
			return index;
		}
		return index + unmodList.size();
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
		Object[] array = toArray();
		int size = toIndex - fromIndex;
		Object[] tmp = new Object[size];
		System.arraycopy(array, fromIndex, tmp, 0, size);
		return (List<E>) Arrays.asList(tmp);
	}

	private boolean isModifiableList(int index) {
		return index >= unmodList.size();
	}

	private int getModifiablePartIndex(int index) {
		return index - unmodList.size();
	}

}
