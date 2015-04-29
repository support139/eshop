package com.epam.khodyka.service.impl;

import com.epam.khodyka.bean.SignupFormBean;
import com.epam.khodyka.db.UserRepository;
import com.epam.khodyka.db.entiry.User;
import com.epam.khodyka.db.exception.UserAlreadyExistException;
import com.epam.khodyka.db.impl.LocalUserRepository;
import com.epam.khodyka.service.UserService;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = new LocalUserRepository();
	}

	@Override
	public boolean isUserExists(String login) {
		return userRepository.get(login) != null;
	}

	@Override
	public void createUser(SignupFormBean formBean) throws UserAlreadyExistException {
		if (isUserExists(formBean.getLogin().getValue())) {
			throw new UserAlreadyExistException();
		}
		User user = new User();
		user.setLogin(formBean.getLogin().getValue());
		user.setPassword(formBean.getPassword().getValue());
		user.setName(formBean.getName().getValue());
		user.setSurname(formBean.getSurname().getValue());
		user.setPassword(formBean.getEmail().getValue());
		userRepository.add(user);
	}
}
