package ru.grinncorp.auth;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GrinnAuthServiceApplicationTests {
	
	@Autowired
	ApplicationContext applicationContext;
	

	@Test
	public void contextLoads() {
		assertNotNull(this.applicationContext,"load context application");
	}

}
