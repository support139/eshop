package com.epam.khodyka.service;

import com.epam.khodyka.bean.SignupFormBean;
import com.epam.khodyka.db.exception.UserAlreadyExistException;

public interface UserService {
	
	boolean isUserExists(String login);
	
	void createUser(SignupFormBean formBean) throws UserAlreadyExistException;
}
