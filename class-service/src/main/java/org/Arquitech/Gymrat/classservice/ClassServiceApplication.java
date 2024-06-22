package org.Arquitech.Gymrat.classservice;

import io.github.cdimascio.dotenv.Dotenv;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@OpenAPIDefinition(
		info = @Info(
				title = "API Class - GymRat",
				version = "1.0",
				description = "API to manage classes part of the application called GymRat"
		)
)
@SpringBootApplication
@EnableFeignClients
public class ClassServiceApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("RAILWAY_DB_HOST", dotenv.get("RAILWAY_DB_HOST"));
		System.setProperty("RAILWAY_DB_PORT", dotenv.get("RAILWAY_DB_PORT"));
		System.setProperty("RAILWAY_DB_NAME", dotenv.get("RAILWAY_DB_NAME"));
		System.setProperty("RAILWAY_DB_USERNAME", dotenv.get("RAILWAY_DB_USERNAME"));
		System.setProperty("RAILWAY_DB_PASSWORD", dotenv.get("RAILWAY_DB_PASSWORD"));

		System.out.println("RAILWAY_DB_HOST: " + System.getProperty("RAILWAY_DB_HOST"));
		System.out.println("RAILWAY_DB_PORT: " + System.getProperty("RAILWAY_DB_PORT"));
		System.out.println("RAILWAY_DB_NAME: " + System.getProperty("RAILWAY_DB_NAME"));
		System.out.println("RAILWAY_DB_USERNAME: " + System.getProperty("RAILWAY_DB_USERNAME"));
		System.out.println("RAILWAY_DB_PASSWORD: " + System.getProperty("RAILWAY_DB_PASSWORD"));

		SpringApplication.run(ClassServiceApplication.class, args);
	}

}
