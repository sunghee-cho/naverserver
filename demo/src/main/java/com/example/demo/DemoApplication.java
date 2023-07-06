package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import board.spring.mybatis.BoardController;
import board.spring.mybatis.MemberDAO;
import upload.UploadController;

@SpringBootApplication
@ComponentScan(basePackageClasses = UploadController.class)
@ComponentScan(basePackageClasses = BoardController.class)
//@ComponentScan(basePackageClasses = ProductController.class)
//@MapperScan(basePackageClasses = ProductDAO.class)
@MapperScan(basePackageClasses = MemberDAO.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
