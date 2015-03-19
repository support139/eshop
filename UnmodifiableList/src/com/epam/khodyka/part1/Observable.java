package com.epam.khodyka.part1;

public interface Observable {
	void addObserver(Observer observer);

	void notifyAllObservers(Object[] snapshot);
}
