package com.alvin.service;

import com.alvin.pojo.User;

public interface UserService {
	User findByUsername(final String username);

	void register(String username, String password);
}
