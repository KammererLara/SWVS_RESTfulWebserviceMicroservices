package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigurationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationServiceApplication.class, args);
	}

	//TODO: testen:
	//	ConfigurationService starten
	//	SensorApi starten
	//	$ curl -X POST localhost:8080/actuator/refresh -d {} -H "Content-Type: application/json"
	//	Port von SensorApi
	//	ODER http://localhost:8080/message öffnen
	//	sollte das zeigen, was unter message in a-bootiful-client.properties steht
}
