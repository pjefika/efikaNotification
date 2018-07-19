package com.telefonica.efikanotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.telefonica.efikanotification","com.telefonica.efikanotification.controller"
,"com.telefonica.efikanotification.repository","com.telefonica.efikanotification.socket"} )
@EntityScan("com.telefonica.efikanotification.model")
public class EfikanotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EfikanotificationApplication.class, args);
	}
}
