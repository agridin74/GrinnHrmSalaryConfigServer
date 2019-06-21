package ru.grinncorp.departments;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Тестирование  подключения JUnit 5.
 * @author agridin74
 * @version 0.0.1
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GrinnDepartmentsServiceApplicationTests {

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
