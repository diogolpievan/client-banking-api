package com.diogo.client_banking_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClientBankingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientBankingApiApplication.class, args);
	}

}
