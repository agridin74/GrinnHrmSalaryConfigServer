package ru.grinncorp.api.application;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import ru.grinncorp.api.dto.Usrslrpaymentprize;

@Component
@RequiredArgsConstructor
public class UsrslrpaymentprizeServiceClient {
	
	private final RestTemplate loadBalancedRestTemplate;
	
	public Usrslrpaymentprize getUsrslrpaymentprize(final Long entityId) {
		return loadBalancedRestTemplate.getForObject("http://payment-prize-service/usrslrpaymentprizes/{entityId}",
				Usrslrpaymentprize.class, entityId);
	}
	
	public List<Usrslrpaymentprize> findAll(){
		ResponseEntity<List<Usrslrpaymentprize>> response = loadBalancedRestTemplate.exchange(
				"http://payment-prize-service/usrslrpaymentprizes/",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Usrslrpaymentprize>>() {
				}				
				);
		List<Usrslrpaymentprize> payments = response.getBody();
		return payments;
	}

}
