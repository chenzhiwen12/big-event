package com.alvin.service.impl;

import com.alvin.mapper.UserMapper;
import com.alvin.pojo.User;
import com.alvin.service.UserService;
import com.alvin.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * packageName com.alvin.service.impl
 *
 * @author 你的名字
 * @version JDK 8
 * @className UserServiceImpl (此处以class为例)
 * @date 2024/6/27 星期四
 * @description TODO
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findByUsername(final String username) {
		return userMapper.findByUsername(username);
	}

	@Override
	public void register(final String username, final String password) {
		final String md5String = Md5Util.getMD5String(password);
		userMapper.add(username, md5String);
	}
}
