package ru.grinncorp.api.application;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import ru.grinncorp.api.dto.Slrdepartment;

@Component
@RequiredArgsConstructor
public class DepartmentsServiceClient {
	
	private final RestTemplate loadBalancedRestTemplate;
	
	public Slrdepartment getSlrdepartment(final Long depId) {
		return loadBalancedRestTemplate.getForObject("http://departments-service/slrdepartments/{depId}", 
				Slrdepartment.class,depId);
	}

}
