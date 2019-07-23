package ru.grinncorp.slrkadr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GrinnSlrkadrServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrinnSlrkadrServiceApplication.class, args);
	}

}
