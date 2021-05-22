package com.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class Question3Application {

	public static void main(String[] args) {
		SpringApplication.run(Question3Application.class, args);
	}

}
