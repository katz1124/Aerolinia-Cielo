package com.cielo.aerolinea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients


public class AerolineaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AerolineaApplication.class, args);
	}

}
