package ru.grinncorp.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author agridin74
 * сервер маршрутизации для обнаружения и регистрации рееста сервисов
 */
@EnableEurekaServer
@SpringBootApplication
public class GrinnHrmSalaryDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrinnHrmSalaryDiscoveryServerApplication.class, args);
	}
}
