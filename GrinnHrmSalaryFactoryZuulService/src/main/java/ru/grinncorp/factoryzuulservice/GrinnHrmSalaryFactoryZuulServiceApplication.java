package ru.grinncorp.factoryzuulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class GrinnHrmSalaryFactoryZuulServiceApplication {
	private static Logger logger = LoggerFactory.getLogger(GrinnHrmSalaryFactoryZuulServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(GrinnHrmSalaryFactoryZuulServiceApplication.class, args);
		logger.info("Start GrinnHrmSalaryFactoryZuulServiceApplication");
	}
}
