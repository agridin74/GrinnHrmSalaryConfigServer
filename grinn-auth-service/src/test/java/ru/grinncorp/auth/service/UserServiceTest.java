package ru.grinncorp.auth.service;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ru.grinncorp.auth.domain.User;
import ru.grinncorp.auth.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Mock
	private UserRepository repository;
	
	@Test
	public void shouldCreateUser() {
		User user = new User();
		user.setUsername("username");
		user.setPassword("password");
		userService.create(user);
		verify(repository,times(1)).save(user);
		
	}
	
	@Test 
	public void shouldFailWhenUserAlreadyExists() {
		assertThrows(IllegalArgumentException.class, () -> {
		User user = new User();
		user.setUsername("username");
		user.setPassword("password");
		when(repository.findById(user.getUsername())).thenReturn(Optional.of(new User()));
		userService.create(user);
		});
		
		
	}
	

}
