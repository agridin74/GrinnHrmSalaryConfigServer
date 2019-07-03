package ru.grinncorp.api;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GrinnApiGatewayApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	/**
	 *  Проверяет загружен ли ApplicationContext
	 * @throws Throwable
	 */
	@Test
	public void contextLoads() throws Throwable {
		assertNotNull(this.applicationContext,"должен был загрузиться контекст приложения." );
	}
}
