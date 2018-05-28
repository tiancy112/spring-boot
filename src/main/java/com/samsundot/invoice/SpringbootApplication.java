package com.samsundot.invoice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.config.EnableAdminServer;

@SpringBootApplication
//@EnableAdminServer
@MapperScan("com.samsundot.invoice.mapper") // 将项目中对应的mapper类的路径加进来就可以了
public class SpringbootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
