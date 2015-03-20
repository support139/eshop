package com.epam.khodyka.part1;

import java.util.ArrayList;
import java.util.Collection;

public class MySet<E> extends ArrayList<E> {

	private static final long serialVersionUID = 8552128732644893795L;

	@Override
	public boolean add(E e) {
		if (contains(e)) {
			return false;
		}
		return super.add(e);
	}

	@Override
	public void add(int index, E element) {
		if (contains(element)) {
			throw new IllegalArgumentException();
		}
		super.add(index, element);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return addAll(size(), c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		for (E o : c) {
			if (contains(o)) {
				return false;
			}
		}
		return super.addAll(index, c);
	}

	@Override
	public E set(int index, E element) {
		if (contains(element)) {
			throw new IllegalArgumentException();
		}
		return super.set(index, element);
	}
}
