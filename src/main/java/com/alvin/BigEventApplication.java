package com.alvin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Hello world!
 */
@SpringBootApplication
public class BigEventApplication {
	public static void main(String[] args) {
		SpringApplication.run(BigEventApplication.class, args);
		System.out.println("Hello World!");
	}
}
