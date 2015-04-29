package com.epam.khodyka.db.impl;

import java.util.HashMap;
import java.util.Map;

import com.epam.khodyka.db.UserRepository;
import com.epam.khodyka.db.entiry.User;

public class LocalUserRepository implements UserRepository {

	private static Map<String, User> users = new HashMap<>();

	static {
		users.put("Statham19", new User(1, "Statham19", "Blabla", "Jason",
				"Statham", "jeka139@mail.ru"));
		users.put("Merkel55", new User(2, "Merkel55", "Dladla", "Angela",
				"Merkel", "angelA@gmail.com"));
	}

	public LocalUserRepository() {
	}

	@Override
	public User get(String login) {
		return users.get(login);
	}

	@Override
	public void add(User user) {
		users.put(user.getLogin(), user);
	}

}
