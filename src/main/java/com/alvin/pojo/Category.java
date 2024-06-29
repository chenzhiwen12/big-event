package com.alvin.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * packageName com.alvin.pojo
 *
 * @author 你的名字
 * @version JDK 8
 * @className Category (此处以class为例)
 * @date 2024/6/27 星期四
 * @description TODO
 */
@Data
public class Category {
	@NotNull(groups = Updatevin.class)
	private Integer id;
	@NotEmpty(groups = {Updatevin.class,Addvin.class})
	private String categoryName;
	@NotEmpty(groups = {Addvin.class,Updatevin.class})
	private String categoryAlias;//分类别名
	private Integer createUser;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updateTime;
	public interface Addvin{}
	public interface Updatevin{}
}
