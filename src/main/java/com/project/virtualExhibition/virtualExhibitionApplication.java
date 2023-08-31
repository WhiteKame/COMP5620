package com.project.virtualExhibition;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.project.virtualExhibition.mapper")
public class virtualExhibitionApplication {

	public static void main(String[] args) {
		SpringApplication.run(virtualExhibitionApplication.class, args);
	}

}
