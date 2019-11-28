package ru.grinncorp.api.application;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
	
	public List<Slrdepartment> findAll() {
		ResponseEntity<List<Slrdepartment>> response = loadBalancedRestTemplate.exchange(
				"http://departments-service/slrdepartments/", 
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Slrdepartment>>() {	});
		List<Slrdepartment> deps = response.getBody();
		return deps;
	}
	/**
	 * @HystrixCommand(fallbackMethod = "Имя_метода_защиты")
    public Объект getИмя метода(параметры.....) {
        return loadBalancedRestTemplate.getForObject и т.д.
    }
    private Объект Имя метода защиты(параметры.....) {
        return Collections.emptyMap();
    }
	 */

}
