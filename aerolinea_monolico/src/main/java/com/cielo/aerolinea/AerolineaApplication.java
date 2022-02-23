package com.cielo.aerolinea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AerolineaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AerolineaApplication.class, args);
	}

}
