package ru.grinncorp.auth.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ru.grinncorp.auth.domain.User;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired 
	private DataSource dataSource;
	
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	private EntityManager entityManager;
	
	@Autowired
	private UserRepository userRepository; 
	
	@Test
	void injectedComponentsAreNotNull() {
		assertThat(dataSource).isNotNull();
		assertThat(jdbcTemplate).isNotNull();
	    assertThat(entityManager).isNotNull();
		assertThat(userRepository).isNotNull();
	}
	
	@Test
	public void shouldSaveAndFindUserByName() {
		User user = new User();
		user.setUsername("username");
		user.setPassword("password");
		userRepository.save(user);
		
		Optional<User> findUser = userRepository.findById(user.getUsername());
		
		assertTrue(findUser.isPresent());
		assertEquals(user.getUsername(), findUser.get().getUsername());
		assertEquals(user.getPassword(), findUser.get().getPassword());
	}
	

}
