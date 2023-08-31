package com.project.memo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.project.memo.mapper")
public class VirtualExihibitionApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualExihibitionApplication.class, args);
	}

}
