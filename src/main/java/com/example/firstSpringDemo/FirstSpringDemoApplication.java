package com.example.firstSpringDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FirstSpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringDemoApplication.class, args);
	}

}
