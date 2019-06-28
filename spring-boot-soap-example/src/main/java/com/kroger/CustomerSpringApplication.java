package com.kroger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.kroger.constants.ConfigProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class CustomerSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerSpringApplication.class, args);
	}
}