package com.vin;

import org.junit.jupiter.api.Test;

/**
 * packageName com.vin
 *
 * @author 你的名字
 * @version JDK 8
 * @className ThreadLocalTest (此处以class为例)
 * @date 2024/6/29 星期六
 * @description TODO
 */
public class ThreadLocalTest {
	@Test
	public void testThreadLocalSetAndGet() {
		ThreadLocal tl = new ThreadLocal<>();
		new Thread(() -> {
			tl.set("pupple");

			System.out.println(Thread.currentThread() + "=" + tl.get());
		}, "red")
				.start();
		new Thread(() -> {
			tl.set("orange");
			System.out.println(Thread.currentThread() + "=" + tl.get());
		}, "emperor")
				.start();
	}
}
