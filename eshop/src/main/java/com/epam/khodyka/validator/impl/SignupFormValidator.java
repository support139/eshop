package com.epam.khodyka.validator.impl;

import com.epam.khodyka.bean.Input;
import com.epam.khodyka.bean.SignupForm;
import com.epam.khodyka.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupFormValidator implements Validator<SignupForm> {

	private static final String LOGIN_NAME_SURNAME_REGEXP = "[a-zA-Z0-9]+$";
	private static final String PASSWORD_REGEXP = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,20}$";
	private static final String EMAIL_REGEXP = "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$";

	@Override
	public boolean isValid(SignupForm object) {
		return isLoginValid(object.getLogin())
				& isPasswordValid(object.getPassword())
				& isNameValid(object.getName())
				& isSurnameValid(object.getSurname())
				& isEmailValid(object.getEmail());
	}

	public boolean isLoginValid(Input login) {
		Pattern pattern = Pattern.compile(LOGIN_NAME_SURNAME_REGEXP);
		Matcher matcher = pattern.matcher(login.getValue());
		if (!matcher.matches()) {
			login.setErrorMessage("Invalid login");
			return false;
		}
		return true;
	}

	public boolean isPasswordValid(Input password) {
		Pattern pattern = Pattern.compile(PASSWORD_REGEXP);
		Matcher matcher = pattern.matcher(password.getValue());
		if (!matcher.matches()) {
			password.setErrorMessage("Invalid password");
			return false;
		}
		return true;
	}

	public boolean isNameValid(Input name) {
		Pattern pattern = Pattern.compile(LOGIN_NAME_SURNAME_REGEXP);
		Matcher matcher = pattern.matcher(name.getValue());
		if (!matcher.matches()) {
			name.setErrorMessage("Invalid name");
			return false;
		}
		return true;
	}

	public boolean isSurnameValid(Input surname) {
		Pattern pattern = Pattern.compile(LOGIN_NAME_SURNAME_REGEXP);
		Matcher matcher = pattern.matcher(surname.getValue());
		if (!matcher.matches()) {
			surname.setErrorMessage("Invalid surname");
			return false;
		}
		return true;
	}

	public boolean isEmailValid(Input email) {
		Pattern pattern = Pattern.compile(EMAIL_REGEXP);
		Matcher matcher = pattern.matcher(email.getValue());
		if (!matcher.matches()) {
			email.setErrorMessage("Invalid email");
			return false;
		}
		return true;
	}

}
