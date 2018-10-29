package ru.grinncorp.factorydashboardservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import ru.grinncorp.factorydashboardservice.slrfactory.SlrfactoryInfoController;

@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
public class GrinnHrmSalaryFactoryDashBoardServiceApplication {
	private static Logger logger = LoggerFactory.getLogger(SlrfactoryInfoController.class);

	public static void main(String[] args) {
		SpringApplication.run(GrinnHrmSalaryFactoryDashBoardServiceApplication.class, args);
		logger.info("Start GrinnHrmSalaryFactoryDashBoardServiceApplication ");
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
