package ru.grinncorp.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author agridin74
 * сервер маршрутизации для обнаружения и регистрации рееста сервисов
 */
@EnableEurekaServer
@SpringBootApplication
public class GrinnHrmSalaryDiscoveryServerApplication {
	
	private static Logger logger = LoggerFactory.getLogger(GrinnHrmSalaryDiscoveryServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GrinnHrmSalaryDiscoveryServerApplication.class, args);
		logger.info("Start Eureka Server ... ");
	}
}
