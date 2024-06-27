package com.alvin.pojo;

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
	private Integer id;
	private String categoryName;
	private String categoryAlias;//分类别名
	private Integer createUser;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
}
