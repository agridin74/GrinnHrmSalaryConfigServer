package ru.grinncorp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
/**
 * 
 * @author agridin74
 *
 */
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableZuulProxy
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
public class GrinnApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrinnApiGatewayApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	RestTemplate loadBalancedRestTemplate() {
		return new RestTemplate();
	}

}
