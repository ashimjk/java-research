package com.ashim.security.basic.user.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ashim.security.basic.user.model.User;

@Service
public class UserService {

	private static List<User> users = Arrays.asList(new User(1, "admin", "admin"), new User(2, "user", "user"));

	public List<User> getUsers() {
		return users;
	}

	public User getUserById(int id) {
		return users.stream().filter(user -> user.getId() == id).findFirst().get();
	}

	public User getUserByName(String userName) {
		return users.stream().filter(user -> user.getUsername().equals(userName)).findFirst().get();
	}
}
