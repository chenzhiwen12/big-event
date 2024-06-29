package com.alvin.controller;

/**
 * packageName com.alvin.controller
 *
 * @author 你的名字
 * @version JDK 8
 * @className UserController (此处以class为例)
 * @date 2024/6/27 星期四
 * @description TODO
 */

import com.alvin.pojo.Result;
import com.alvin.pojo.User;
import com.alvin.service.UserService;
import com.alvin.utils.JwtUtil;
import com.alvin.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public Result register(@Pattern(regexp = "^\\S{5,16}$") final String username, @Pattern(regexp = "\\S{5,16}") final String password) {
		final User exitingUser = userService.findByUsername(username);
		if (exitingUser == null) {
			userService.register(username, password);
			return Result.success();
		} else {
			return Result.error("用户名已被占用");
		}
	}

	@PostMapping("/login")
	public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") final String username, @Pattern(regexp = "\\S{5,16}") final String password) {
		User loginUser = userService.findByUsername(username);
		if (loginUser == null)
			return Result.error("用户名错误");
		if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
			Map<String, Object> claims = new HashMap<>();
			claims.put("id", loginUser.getId());
			claims.put("username", loginUser.getUsername());
			String token = JwtUtil.genToken(claims);
			return Result.success(token);
		}
		return Result.error("密码错误");
	}
}
