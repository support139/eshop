package com.epam.khodyka.db;

import com.epam.khodyka.db.entiry.User;

public interface UserRepository {
	
	User get(String login);
	
	void add(User user);
}
