package com.alvin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * packageName com.alvin.pojo
 *
 * @author 你的名字
 * @version JDK 8
 * @className Result (此处以class为例)
 * @date 2024/6/27 星期四
 * @description TODO
 */
@Data
@AllArgsConstructor
public class Result<T> {
	private Integer code;
	private String message;
	private final T date;

	//快速返回操作成功响应结果(带响应数据)
	public static <T> Result<T> success(T data) {
		return new Result<T>(0, "操作成功", data);
	}

	//快速返回操作成功响应结果
	public static <T> Result<T> success() {
		return new Result<>(0, "操作成功", null);
	}

	public static <T> Result<T> error(String message) {
		return new Result<>(1, message, null);
	}
}
