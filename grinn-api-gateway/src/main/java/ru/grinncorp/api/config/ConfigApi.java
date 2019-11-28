package ru.grinncorp.api.config;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;



//import springfox.documentation.swagger.web.SwaggerResource;
//import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import lombok.extern.slf4j.Slf4j;

/**
 * Предназначен для настройки реализацией поставщика ресурсов Swagger
 * @author agridin74
 * http://localhost:8080/swagger-ui.html
 */
//@Configuration
//@Slf4j
public class ConfigApi {
	//private static final Logger LOGGER = LoggerFactory.getLogger(ConfigApi.class);
	
	//@Autowired
	//ZuulProperties properties;
	
	//@Primary
	//@Bean
//	public SwaggerResourcesProvider swaggerResourcesProvider() {
//		return () -> {
//			List<SwaggerResource> resources = new ArrayList<>();
//			properties.getRoutes().values().stream()
//			.forEach(route -> {
//				 resources.add(createResource(route.getServiceId(), route.getId(), "2.0"));
//				// log.info("MYROUTE {}",route);
//			
//			}
//				 );
//			return resources;
//		};
//	}
//	
//	private SwaggerResource createResource(String name, String location, String version) {
//		SwaggerResource swaggerResource = new SwaggerResource();
//		swaggerResource.setName(name);
//		swaggerResource.setLocation("/" + location + "/v2/api-docs");
//		swaggerResource.setSwaggerVersion(version);
//		return swaggerResource;
//	}

}
