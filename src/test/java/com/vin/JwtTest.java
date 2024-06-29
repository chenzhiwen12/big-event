package com.vin;

import com.alvin.utils.JwtUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * packageName com.vin
 *
 * @author 你的名字
 * @version JDK 8
 * @className JwtTest (此处以class为例)
 * @date 2024/6/29 星期六
 * @description TODO
 */
public class JwtTest {
	Map<String, Object> claims = new HashMap<>();

	@Test
	public void testGen() {
		claims.put("id", 1);
		claims.put("username", "vine");
		String token = JWT.create()
				.withClaim("user", claims)
				.withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
				.sign(Algorithm.HMAC256("vin"));
		System.out.printf(token);
	}

	@Test
	public void testParse() {
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6InZpbmUifSwiZXhwIjoxNzE5NjQxNDQ3fQ.3qyf4Y6i7KGUiNk6UDG2HhTfa9fUqMvebS01PtdQlUk";
		JWTVerifier vin = JWT.require(Algorithm.HMAC256("vin")).build();
		DecodedJWT verify = vin.verify(token);
		Map<String, Claim> claims1 = verify.getClaims();
		System.out.println("claims1.get(\"id\") = " + claims1.get("user").asMap().get("id"));

	}

	@Test
	public void testJWT() {
//		claims.put("id", 1);
		claims.put("username", "vine");
//		String token = JwtUtil.genToken((Map<String, Object>) new HashMap<>().put("me","you"));
		String token = JwtUtil.genToken(claims);
		System.out.println(token);
		Map<String, Object> stringObjectMap = JwtUtil.parseToken(token);
		System.out.println(stringObjectMap);
	}
}
