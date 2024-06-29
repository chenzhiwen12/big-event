package com.alvin.service.impl;

import com.alvin.mapper.UserMapper;
import com.alvin.pojo.User;
import com.alvin.service.UserService;
import com.alvin.utils.Md5Util;
import com.alvin.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

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

	@Override
	public void update(User user) {
		user.setUpdateTime(LocalDateTime.now());
		userMapper.update(user);
	}

	@Override
	public void updateAvatar(String userPic) {
		Map<String,Object> map = ThreadLocalUtil.get();
		Integer id = (Integer) map.get("id");
		userMapper.updateAvatar(userPic,id);
	}

	@Override
	public void updatePwd(String updatePwd) {
		Map<String,Object> map = ThreadLocalUtil.get();
		Integer id = (Integer) map.get("id");
		userMapper.updatePwd(id,Md5Util.getMD5String(updatePwd));
	}
}
