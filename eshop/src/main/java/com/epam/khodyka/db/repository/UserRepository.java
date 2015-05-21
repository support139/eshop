package com.epam.khodyka.db.repository;

import com.epam.khodyka.db.entiry.User;

// TODO Implements userRepository with Proxy

public interface UserRepository {

	User get(int id);

	User get(String login);
	
	int add(User user);

}
