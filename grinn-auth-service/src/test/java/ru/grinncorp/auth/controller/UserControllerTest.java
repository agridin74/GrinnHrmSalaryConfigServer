package ru.grinncorp.auth.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.sun.security.auth.UserPrincipal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.grinncorp.auth.domain.User;
import ru.grinncorp.auth.service.UserService;



@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserControllerTest {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	@InjectMocks
	private UserController userController; 
	@Mock
	private UserService userService;
	
	MockMvc mvc;
	
	

	@Test
	public void shouldCreateNewUser() throws Exception {
		this.mvc = MockMvcBuilders.standaloneSetup(userController).build();
		final User user = new User();
		user.setUsername("username");
		user.setPassword("password");

		String json = mapper.writeValueAsString(user);

		mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());
	}
	
	@Test
	public void shouldFailWhenUserIsNotValid() throws Exception{
		this.mvc = MockMvcBuilders.standaloneSetup(userController).build();
		final User user = new User();
		user.setUsername("invaliduser");
		user.setPassword("invalidpassword");
		mvc.perform(post("/users"))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void shouldReturnCurrentUser() throws Exception {
		this.mvc = MockMvcBuilders.standaloneSetup(userController).build();
		mvc.perform(get("/users/current").principal(new UserPrincipal("test")))
			.andExpect(jsonPath("$.name").value("test"))
			.andExpect(status().isOk());
	}
	
	
}
