package com.epam.khodyka.part1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ProtectedIteratorList<E> extends ArrayList<E> implements
		Observable {

	private static final long serialVersionUID = -7056059579339170082L;
	private List<Observer> iterators = new ArrayList<>();

	@Override
	public boolean add(E e) {
		add(size(), e);
		return true;
	}

	@Override
	public void add(int index, E element) {
		Object[] snapshot = checkIterators();
		super.add(index, element);
		notifyAllObservers(snapshot);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return addAll(size(), c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		Object[] snapshot = checkIterators();
		if (super.addAll(index, c)) {
			notifyAllObservers(snapshot);
			return true;
		}
		return false;
	}

	@Override
	public E set(int index, E element) {
		Object[] snapshot = checkIterators();
		E oldValue = super.set(index, element);
		notifyAllObservers(snapshot);
		return oldValue;
	}

	@Override
	public E remove(int index) {
		Object[] snapshot = checkIterators();
		E oldValue = super.remove(index);
		notifyAllObservers(snapshot);
		return oldValue;
	}

	@Override
	public boolean remove(Object o) {
		Object[] snapshot = checkIterators();
		if (super.remove(o)) {
			notifyAllObservers(snapshot);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		Object[] snapshot = checkIterators();
		if (super.removeAll(c)) {
			notifyAllObservers(snapshot);
			return true;
		}
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		Object[] snapshot = checkIterators();
		if (super.retainAll(c)) {
			notifyAllObservers(snapshot);
			return true;
		}
		return false;
	}

	private Object[] checkIterators() {
		if (iterators.isEmpty()) {
			return null;
		}
		return super.toArray();
	}

	@Override
	public Iterator<E> iterator() {
		CopyOnWriteIterator<E> iterator = new CopyOnWriteIterator<E>();
		addObserver(iterator);
		return iterator;
	}

	private class CopyOnWriteIterator<E> implements Iterator<E>, Observer {

		private Object[] snapshot;
		private int size = size();
		private int cursor;
		private boolean hasBeenModified;

		@Override
		public boolean hasNext() {
			return cursor < size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			if (hasBeenModified) {
				return (E) snapshot[cursor++];
			}
			return (E) get(cursor++);
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void update(Object[] snapshot) {
			if (!hasBeenModified) {
				this.snapshot = snapshot;
				hasBeenModified = true;
			}
		}

	}

	@Override
	public void addObserver(Observer iterator) {
		iterators.add(iterator);
	}

	@Override
	public void notifyAllObservers(Object[] snapshot) {
		if (snapshot == null) {
			return;
		}
		for (int i = 0; i < iterators.size(); i++) {
			iterators.get(i).update(snapshot);
			iterators.remove(i);
		}
	}

}
