
package ru.grinncorp.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Класс сервера конфигурации
 * http://localhost:9090/config/default
 * @author agridin74
 * @version 0.0.1
 * 
 */
@EnableConfigServer
@SpringBootApplication
public class GrinnHrmSalaryConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrinnHrmSalaryConfigServerApplication.class, args);
		
	}
}
