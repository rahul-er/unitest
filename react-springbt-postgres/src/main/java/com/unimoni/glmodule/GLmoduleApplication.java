package com.unimoni.glmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.unimoni.glmodule")
public class GLmoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GLmoduleApplication.class, args);
	}

}
