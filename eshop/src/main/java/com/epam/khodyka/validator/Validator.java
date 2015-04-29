package com.epam.khodyka.validator;

public interface Validator<E> {
	boolean isValid(E object);
}
