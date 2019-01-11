package com.zt.jinanzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import de.codecentric.boot.admin.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
@ComponentScan(basePackages="com.zt")
public class YlApplication {

	public static void main(String[] args) {
		SpringApplication.run(YlApplication.class, args);
	}

}
