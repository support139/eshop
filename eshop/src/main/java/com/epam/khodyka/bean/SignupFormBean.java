package com.epam.khodyka.bean;

public class SignupFormBean {

	private Input login;
	private Input password;
	private Input name;
	private Input surname;
	private Input email;

	public SignupFormBean() {
		this.login = new StringInput();
		this.password = new StringInput();
		this.name = new StringInput();
		this.surname = new StringInput();
		this.email = new StringInput();
	}

	public Input getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login.setValue(login);
	}

	public Input getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password.setValue(password);
	}

	public Input getName() {
		return name;
	}

	public void setName(String name) {
		this.name.setValue(name);
	}

	public Input getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname.setValue(surname);
	}

	public Input getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email.setValue(email);
	}
}
