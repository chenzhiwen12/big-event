package com.alvin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * packageName com.alvin.pojo
 *
 * @author 你的名字
 * @version JDK 8
 * @className PageBean (此处以class为例)
 * @date 2024/7/2 星期二
 * @description TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean <T>{
	private Long total;
	private List<T> items;
}
