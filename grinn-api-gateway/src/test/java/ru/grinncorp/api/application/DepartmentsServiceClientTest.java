package ru.grinncorp.api.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import ru.grinncorp.api.dto.Slrdepartment;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@EnableCircuitBreaker
@EnableAspectJAutoProxy
@SpringJUnitConfig(classes = {DepartmentsServiceClient.class, RestTemplate.class})
public class DepartmentsServiceClientTest {
	
	private static final Long DEP_ID=1l;
	
	@Autowired
	DepartmentsServiceClient departmentsServiceClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private MockRestServiceServer mockServer;
	
	@BeforeEach
	public void setUp() {
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}
	
	@Test
	public void getSlrdepartment_withAvailableDepartmentsService() {
		mockServer.expect(requestTo("http://departments-service/slrdepartments/1"))
			.andRespond(withSuccess("{\"id\":1,\"idparent\":0,\"snm\":\"АО \\\"TEST \\\"TEST\\\"\","
					+ "\"codinref\":60335001,\"idcard\":null,\"sremark\":null,\"smnemocode\":\"1\",\"slevel\""
					+ ":\"001\",\"snmlong\":\"Акционерное общество \\\"TESTKORP \\\"TEST\\\"\",\"dbegin\""
					+ ":\"1899-12-31T21:00:00.000+0000\",\"dend\":null,\"dendorder\":null,\"dendclose\":null"
					+ ",\"llist\":\"N\",\"lhide\":\"N\",\"lnvd\":\"N\",\"lnoishl\":\"N\",\"idfactory\":{\"id\":1"
					+ ",\"snm\":\"АО \\\"TESTKORP \\\"TEST\\\"\",\"slongname\":\"Акционерное общество \\\"TESTKORP"
					+ " \\\"TEST\\\"\",\"sokpo\":\"05179943\",\"sokonh\":\"7110\",\"stown\":\"TESTTOWN\",\"sadress\":\"302042, г. "
					+ "ADDR4\",\"sadressf\":\"305000,ADDR6\",\"sphone\":\"(4712) "
					+ "52-13-45\",\"sinn\":\"4629045050\",\"skpp\":\"575201001\",\"sgni\":\"5752\",\"sbank\":null,\"sfio1\":\""
					+ "BOSSFIO\",\"sfio2\":\"FIO2\",\"sfio3\":\"FIO3\",\"sfio4\":\"FIO4\",\""
					+ "sfio5\":\"TESTFIO\",\"codbr\":null,\"spfnumber\":\"023-021-067307\",\"sfio6\":null,\"sokved\":\"47.1\""
					+ ",\"sokopf\":\"67\",\"sokato\":\"54701000\",\"sokogu\":\"1\",\"sokdp\":\"1\",\"sgniname\":\""
					+ "Инспекция ФНС России по TEST\",\"sokfs\":\"12\",\"sindex\":\"302010\",\"sregion\":null,\""
					+ "svillage\":null,\"sstreet\":\"TESTADDR\",\"shouse\":\"4\",\"skorpus\":null,\"sflat\":null,\"sogrn\":\""
					+ "1024600949185\",\"sfssnumber\":\"4629105440\",\"sfssparentnumber\":\"57001\",\"sfssaddnumber\":null},\""
					+ "idbranches\":{\"id\":1,\"smnemocode\":\"КУРСК\",\"snm\":\"АО \\\"TESTKORP \\\"TEST\\\"\",\"idfactory\""
					+ ":{\"id\":1,\"snm\":\"АО \\\"TESTKORP \\\"TEST\\\"\",\"slongname\":\"Акционерное общество \\\"TESTKORP "
					+ "\\\"TEST\\\"\",\"sokpo\":\"05179943\",\"sokonh\":\"7110\",\"stown\":\"TYRY\",\"sadress\":\"302042, г. TYR, "
					+ "TESTADDR\",\"sadressf\":\"305023, TESTADDR1\",\"sphone\":\"(4734) 67-13-45\","
					+ "\"sinn\":\"4629045050\",\"skpp\":\"575201001\",\"sgni\":\"5752\",\"sbank\":null,\"sfio1\":\"FIO\","
					+ "\"sfio2\":\"FIO3\",\"sfio3\":\"Т. Т. Стрелкова\",\"sfio4\":\"TESTFIO2\",\"sfio5\":\""
					+ "TESTFIO2\",\"codbr\":null,\"spfnumber\":\"067-021-028307\",\"sfio6\":null,\"sokved\":\"47.1\",\"sokopf\""
					+ ":\"67\",\"sokato\":\"54701000\",\"sokogu\":\"1\",\"sokdp\":\"1\",\"sgniname\""
					+ ":\"Инспекция ФНС России по TESTIFNS\",\"sokfs\":\"12\",\"sindex\":\"302010\""
					+ ",\"sregion\":null,\"svillage\":null,\"sstreet\":\"TESTADDR22\",\"shouse\":\"4\",\""
					+ "skorpus\":null,\"sflat\":null,\"sogrn\":\"23423600949185\",\"sfssnumber\":\"2342234440\",\""
					+ "sfssparentnumber\":\"57034\",\"sfssaddnumber\":null}}}", MediaType.APPLICATION_JSON));
		Slrdepartment dep = departmentsServiceClient.getSlrdepartment(DEP_ID);
		
		assertNotNull(dep.getId());
		assertEquals(Long.valueOf(1), dep.getId());
	}
	
	/*@Test
	public void getSlrdepartment_withServerError() {
		mockServer.expect(requestTo("http://departments-service/slrdepartments/1"))
			.andRespond(withServerError());
		Slrdepartment dep = departmentsServiceClient.getSlrdepartment(DEP_ID);
		System.out.println(dep);
		//assertNull(dep);
	}*/
	
	

}
