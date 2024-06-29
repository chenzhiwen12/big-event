package com.alvin.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
@NoArgsConstructor
public class User {
	@NonNull
	private Integer id;
	private String username;
	@JsonIgnore
	private String password;
	@NotEmpty
	@Pattern(regexp = "^\\S{1,10}$")
	private String nickname;
	@NotEmpty
	@Email
	private String email;
	private String userPic;//用户头像地址
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
}
