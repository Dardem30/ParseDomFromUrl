package com.example.parsedomfromurl;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParseDomFromUrlApplication {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(ParseDomFromUrlApplication.class, args);
	}
}
