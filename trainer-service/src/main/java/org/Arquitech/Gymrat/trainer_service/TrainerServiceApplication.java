package org.Arquitech.Gymrat.trainer_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@OpenAPIDefinition(
		info = @Info(
				title = "API Trainer - GymRat",
				version = "1.0",
				description = "API to manage trainers part of the application called GymRat"
		)
)
@EnableFeignClients
@SpringBootApplication
public class TrainerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainerServiceApplication.class, args);
	}

}
