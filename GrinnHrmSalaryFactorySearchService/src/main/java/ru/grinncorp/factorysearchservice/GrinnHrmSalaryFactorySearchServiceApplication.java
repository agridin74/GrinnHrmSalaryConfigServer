package ru.grinncorp.factorysearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableDiscoveryClient
@SpringBootApplication
public class GrinnHrmSalaryFactorySearchServiceApplication {
	
	private static Logger logger =  LoggerFactory.getLogger(GrinnHrmSalaryFactorySearchServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GrinnHrmSalaryFactorySearchServiceApplication.class, args);
		logger.info("Start Factory Search Service ...");
	}
}
