package com.epam.khodyka.service;

import com.epam.khodyka.bean.LoginForm;
import com.epam.khodyka.bean.SignupForm;
import com.epam.khodyka.db.entiry.User;
import com.epam.khodyka.db.exception.UserAlreadyExistException;

public interface UserService {
	
	boolean isUserExists(String login);
	
	void createUser(SignupForm formBean) throws UserAlreadyExistException;

	User login(LoginForm loginForm);
}
