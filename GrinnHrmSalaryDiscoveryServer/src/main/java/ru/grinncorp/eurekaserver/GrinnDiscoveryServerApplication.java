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
public class GrinnDiscoveryServerApplication {
	
	private static Logger logger = LoggerFactory.getLogger(GrinnDiscoveryServerApplication.class);

	public static void main(String[] args) {
		//Установка для поиска файла конфигурации отличного от стандартного
		//System.setProperty("spring.config.name", "example-registration-server");
		SpringApplication.run(GrinnDiscoveryServerApplication.class, args);
		logger.info("Start Eureka Server ... ");
	}
}
