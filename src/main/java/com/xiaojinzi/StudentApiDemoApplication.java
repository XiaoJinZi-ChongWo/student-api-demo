package com.xiaojinzi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xiaojinzi.repository.mapper")
public class StudentApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApiDemoApplication.class, args);
	}
}
