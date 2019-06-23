package com.kroger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.kroger")
public class MySpringApplicationClient {
	public static void main(String[] args) {
		SpringApplication.run(MySpringApplicationClient.class, args);
	}

}