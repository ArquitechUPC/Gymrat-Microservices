package org.Arquitech.Gymrat.clientservice;

import io.github.cdimascio.dotenv.Dotenv;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@OpenAPIDefinition(
		info = @Info(
				title = "API Client - GymRat",
				version = "1.0",
				description = "API to manage client part of the application called GymRat"
		)

)
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
public class ClientServiceApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();
		System.setProperty("RAILWAY_DB_HOST", dotenv.get("RAILWAY_DB_HOST"));
		System.setProperty("RAILWAY_DB_PORT", dotenv.get("RAILWAY_DB_PORT"));
		System.setProperty("RAILWAY_DB_NAME", dotenv.get("RAILWAY_DB_NAME"));
		System.setProperty("RAILWAY_DB_USERNAME", dotenv.get("RAILWAY_DB_USERNAME"));
		System.setProperty("RAILWAY_DB_PASSWORD", dotenv.get("RAILWAY_DB_PASSWORD"));

		SpringApplication.run(ClientServiceApplication.class, args);
	}

}
