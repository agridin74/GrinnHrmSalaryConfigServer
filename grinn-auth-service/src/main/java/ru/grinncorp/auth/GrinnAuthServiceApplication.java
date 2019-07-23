package ru.grinncorp.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;




@SpringBootApplication
@EnableResourceServer //означает что он будет принимать запросы только с действительным токеном доступа
@EnableDiscoveryClient
@EnableGlobalMethodSecurity(prePostEnabled = true)//обеспечивает безопасность AOP для методов
public class GrinnAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrinnAuthServiceApplication.class, args);
	}

}
