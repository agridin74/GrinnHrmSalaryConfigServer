package ru.grinncorp.auth.service.security;


import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ru.grinncorp.auth.domain.User;
import ru.grinncorp.auth.repository.UserRepository;

import java.util.Optional;



@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OraUserDetailsServiceTest {
	
	@InjectMocks
	private OraUserDetailsService service;
	
	@Mock
	private UserRepository repository;
	
	@Test
	public void shouldLoadByUsernameWhenUserExists() {
		final User user = new User();
		
		when(repository.findById(Mockito.anyString())).thenReturn(Optional.of(user));
		UserDetails loaded = service.loadUserByUsername("username");
		assertEquals(user, loaded);
	}
	
	@Test
	public void shouldFailToLoadByUsernameWhenUserNotExists() {
		assertThrows(UsernameNotFoundException.class, () -> service.loadUserByUsername("username"));
		
		
	}

}
