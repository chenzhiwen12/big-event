package com.alvin.controller;

import com.alvin.pojo.Result;
import com.alvin.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * packageName com.alvin.controller
 *
 * @author 你的名字
 * @version JDK 8
 * @className ArticleController (此处以class为例)
 * @date 2024/6/29 星期六
 * @description TODO
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
	/*	@GetMapping("/list")
		public Result<String> list(@RequestHeader(name = "Authorization") String token, HttpServletResponse response){
			Map<String, Object> claims = null;
			try {
				claims = JwtUtil.parseToken(token);
			} catch (Exception e) {
				response.setStatus(401);
				return Result.error("unlogin");
			}
			return Result.success(claims.toString());
		}*/
	@GetMapping("/list")
	public Result<String> list() {
		return Result.success("datas");
	}
}
