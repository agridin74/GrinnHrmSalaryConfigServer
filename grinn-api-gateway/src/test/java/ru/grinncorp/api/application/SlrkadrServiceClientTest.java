package ru.grinncorp.api.application;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import ru.grinncorp.api.dto.Slrkadr;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableCircuitBreaker
@EnableAspectJAutoProxy
@SpringJUnitConfig(classes = {SlrkadrServiceClient.class, RestTemplate.class})
public class SlrkadrServiceClientTest {
	
	private static final Long ENTITY_ID=1l;
	
	@Autowired
	private SlrkadrServiceClient slrkadrServiceClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private MockRestServiceServer mockServer;
	
	@BeforeEach
	public void setUp() {
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}
	
	@Test
	public void getSlrkadr_withAvailableSlrkadrService() {
		mockServer.expect(requestTo("http://slrkadr-service/slrkadrs/1"))
			.andRespond(withSuccess("{\"lsex\":\"Y\",\"lworker\":\"Y\",\"id\":1,"+
					"\"sfirstname\":\"Антон\",\"ssecondname\":\"TEST\",\"sthirdname\":\"Testич\","
					+ "\"snm\":\"TEST А. В.\",\"dbirthdate\":\"1983-09-28T20:00:00.000+0000\",\"sbirthregion\":null,"
					+ "\"sbirtharea\":\"Testая\",\"sbirthtown\":\"Test\",\"sfirstnamerp\":\"Testа\","
					+ "\"ssecondnamerp\":\"TESTу\",\"sthirdnamerp\":\"TESTча\",\"sfirstnamedp\":\"Testу\","
					+ "\"ssecondnamedp\":\"TESTе\",\"sthirdnamedp\":\"TESTчу\",\"semail\":null,\"sinn\":null,"
					+ "\"spfnumber\":null,\"spfcategory\":null,\"sgni\":null,\"idnationality\":null,"
					+ "\"idlanguage\":1,\"idcountry\":643,\"idcitizenship\":1,\"idalientcategory\":null,"
					+ "\"codct\":61567001}",MediaType.APPLICATION_JSON));
		Slrkadr kadr = slrkadrServiceClient.getSlrkadr(ENTITY_ID);
		assertNotNull(kadr.getId());
		assertEquals(Long.valueOf(1), kadr.getId());
		
			
	}
	

}
