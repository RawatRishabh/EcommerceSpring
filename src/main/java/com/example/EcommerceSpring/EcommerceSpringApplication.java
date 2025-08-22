package com.example.EcommerceSpring;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // optional
@EnableDiscoveryClient
public class EcommerceSpringApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load(); // load environment variable from .env file
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(),entry.getValue())); // get the environment variables and set them
		SpringApplication.run(EcommerceSpringApplication.class, args);
	}

}
