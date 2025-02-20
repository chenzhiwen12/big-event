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
import com.alvin.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

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
			//将token保存到redis 中
			ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
			operations.set(token, token, 1, TimeUnit.HOURS);
			return Result.success(token);
		}
		return Result.error("密码错误");
	}

	@GetMapping("/userInfo")
	public Result<User> userInfo(@RequestHeader(name = "Authorization") String token) {
		/*Map<String, Object> map = JwtUtil.parseToken(token);
		String username = (String) map.get("username");*/
		Map<String, Object> claims = ThreadLocalUtil.get();
		String username = (String) claims.get("username");
		User user = userService.findByUsername(username);
		return Result.success(user);
	}

	@PutMapping("/update")
	public Result update(@RequestBody @Validated User user) {
		userService.update(user);
		return Result.success("更新成功");
	}

	@PatchMapping("/updateAvatar")
	public Result updateAvatar(@RequestParam @URL final String userPic) {
		userService.updateAvatar(userPic);
		return Result.success();
	}

	@PatchMapping("/updatePwd")
	public Result updatePwd(@RequestBody Map<String, String> params,@RequestHeader("Authorization") String token) {
		String oldPwd = params.get("old_pwd");
		String newPwd = params.get("new_pwd");
		String rePwd = params.get("re_pwd");
		if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)) {
			return Result.error("缺少必要的参数");
		}
		Map map = ThreadLocalUtil.get();
		String username = (String) map.get("username");
		User user = userService.findByUsername(username);
		if (!user.getPassword().equals(Md5Util.getMD5String(oldPwd))) {
			return Result.error("原密码填写不正确");
		}
		if (!rePwd.equals(oldPwd))
			return Result.error("两次填写密码不一样");
		userService.updatePwd(newPwd);
		ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
		operations.getOperations().delete(token);
		return Result.success();
	}
}
