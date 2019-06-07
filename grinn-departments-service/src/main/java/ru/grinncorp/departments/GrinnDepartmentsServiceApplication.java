package ru.grinncorp.departments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GrinnDepartmentsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrinnDepartmentsServiceApplication.class, args);
	}

}
