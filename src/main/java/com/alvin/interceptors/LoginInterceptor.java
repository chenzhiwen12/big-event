package com.alvin.interceptors;

import com.alvin.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * packageName com.alvin.interceptors
 *
 * @author 你的名字
 * @version JDK 8
 * @className LoginInterceptor (此处以class为例)
 * @date 2024/6/29 星期六
 * @description TODO
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String token = request.getHeader("Authorization");
		try {
			Map<String,Object> claims= JwtUtil.parseToken(token);
			return true;
		} catch (Exception e) {
			response.setStatus(401);
			return false;
		}
	}

}
