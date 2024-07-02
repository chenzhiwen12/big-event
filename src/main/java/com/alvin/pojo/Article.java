package com.alvin.pojo;

import com.alvin.anno.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

/**
 * packageName com.alvin.pojo
 *
 * @author 你的名字
 * @version JDK 8
 * @className Article (此处以class为例)
 * @date 2024/6/27 星期四
 * @description TODO
 */
@Data
public class Article {
	private Integer id;
	@NotEmpty
	@Pattern(regexp = "^\\S{1,10}$")
	private String title;
	@NotEmpty
	private String content;
	@NotEmpty
	@URL
	private String coverImg;
	@State
	private String state;
	@NotNull
	private Integer categoryId;
	private Integer createUser;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
}
