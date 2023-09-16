package com.ecomerce.ecomerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
@RestController
public class EComerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EComerceApplication.class, args);
	}

	@GetMapping(value="/")
	public String getMethodName() {
		return "Bem Vindo à API Ecomerce !";
	}
	

}
