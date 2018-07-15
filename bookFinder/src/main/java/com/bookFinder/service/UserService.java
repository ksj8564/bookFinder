package com.bookFinder.service;

import com.bookFinder.model.User;

public interface UserService {
	public User findUserByUsername(String username);
	public void saveUser(User user);
}
