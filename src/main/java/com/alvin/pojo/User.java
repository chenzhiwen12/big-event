package com.alvin.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * packageName com.alvin.pojo
 *
 * @author 你的名字
 * @version JDK 8
 * @className User (此处以class为例)
 * @date 2024/6/27 星期四
 * @description TODO
 */
@Data
public class User {
	private Integer id;
	private String username;
	private String password;
	private String nickname;
	private String email;
	private String userPic;//用户头像地址
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
}
