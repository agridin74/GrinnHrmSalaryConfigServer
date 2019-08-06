package ru.grinncorp.paymentprize;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GrinnPaymentPrizeServiceApplicationTests {
	
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void contextLoads() throws Throwable{
		assertNotNull(this.applicationContext, "Load application context");
	}

}
