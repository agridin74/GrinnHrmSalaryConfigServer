package ru.grinncorp.api.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

import ru.grinncorp.api.dto.Usrslrpaymentprize;

@EnableCircuitBreaker
@EnableAspectJAutoProxy
@SpringJUnitConfig(classes = {UsrslrpaymentprizeServiceClient.class, RestTemplate.class})
public class UsrslrpaymentprizeServiceClientTest {
	
	private static final Long ENTITY_ID=1l;
	
	@Autowired
	private UsrslrpaymentprizeServiceClient usrslrpaymentprizeServiceClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private MockRestServiceServer mockServer;
	
	
	@BeforeEach
	public void setUp() {
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}
	
	@Test
	public void getUsrslrpaymentprize_withAvailableUsrslrpaymentprizeService() {
		mockServer.expect(requestTo("http://payment-prize-service/usrslrpaymentprizes/1"))
			.andRespond(withSuccess("{\"id\":1,\"idfactory\":1,\"idbranches\":1,\"iddepartment\":1,"
					+ "\"snm\":\"Тест\",\"idkadr\":1,\"idincome\":1,\"nmoney\":1,\"nmoneyvichet\":1,"
					+ "\"ntaxprc\":1,\"ntaxmoney\":1,\"dperiod\":\"2019-08-02T07:33:51.000+0000\","
					+ "\"dperiodfrom\":\"2019-08-02T07:33:51.000+0000\","
					+ "\"dperiodfromuser\":\"2019-08-02T07:33:51.000+0000\","
					+ "\"dfactpayed\":\"2019-08-02T07:33:51.000+0000\","
					+ "\"dperiodtax\":\"2019-08-02T07:33:51.000+0000\","
					+ "\"dpayofftax\":\"2019-08-02T07:33:51.000+0000\","
					+ "\"dtimelimittax\":\"2019-08-02T07:33:51.000+0000\","
					+ "\"sremark\":\"Тест\",\"idcreator\":null,\"ideditor\":null,"
					+ "\"dcreatedatetime\":\"2019-08-02T07:33:51.000+0000\","
					+ "\"deditdatetime\":\"2019-08-02T07:33:51.000+0000\"}",MediaType.APPLICATION_JSON));
		Usrslrpaymentprize payment =usrslrpaymentprizeServiceClient.getUsrslrpaymentprize(ENTITY_ID);
		assertNotNull(payment.getId());
		assertEquals(Long.valueOf(1), payment.getId());
	}

}
