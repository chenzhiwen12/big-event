package com.alvin.service;

import com.alvin.pojo.User;

public interface UserService {
	User findByUsername(final String username);

	void register(String username, String password);

	void update(User user);

	void updateAvatar(String userPic);

	void updatePwd(final String updatePwd);
}
