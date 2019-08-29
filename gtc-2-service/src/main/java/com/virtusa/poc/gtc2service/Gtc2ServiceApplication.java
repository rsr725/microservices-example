package com.virtusa.poc.gtc2service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients("com.virtusa.poc.gtc2service")
@EnableDiscoveryClient
public class Gtc2ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Gtc2ServiceApplication.class, args);
	}

	
}
