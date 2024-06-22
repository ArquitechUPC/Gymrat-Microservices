package org.Arquitech.Gymrat.planservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PlanServiceApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("RAILWAY_DB_HOST", dotenv.get("RAILWAY_DB_HOST"));
		System.setProperty("RAILWAY_DB_PORT", dotenv.get("RAILWAY_DB_PORT"));
		System.setProperty("RAILWAY_DB_NAME", dotenv.get("RAILWAY_DB_NAME"));
		System.setProperty("RAILWAY_DB_USERNAME", dotenv.get("RAILWAY_DB_USERNAME"));
		System.setProperty("RAILWAY_DB_PASSWORD", dotenv.get("RAILWAY_DB_PASSWORD"));

		SpringApplication.run(PlanServiceApplication.class, args);
	}

}
