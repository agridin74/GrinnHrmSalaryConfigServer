package ru.grinncorp.api.application;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import ru.grinncorp.api.dto.Slrkadr;

@Component
@RequiredArgsConstructor
public class SlrkadrServiceClient {
	
	private final RestTemplate loadBalancedRestTemplate;
	
	public Slrkadr getSlrkadr(final Long entityId) {
		return loadBalancedRestTemplate.getForObject("http://slrkadr-service/slrkadrs/{entityId}", 
				Slrkadr.class, entityId);
	}
	
	public List<Slrkadr> findAll(){
		ResponseEntity<List<Slrkadr>> response = loadBalancedRestTemplate.exchange(
				"http://slrkadr-service/slrkadrs/",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Slrkadr>>() {});
		List<Slrkadr> kadrs = response.getBody();
		return kadrs;
	}

}
