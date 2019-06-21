package ru.grinncorp.departments;

import java.util.Optional;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import ru.grinncorp.departments.controller.SlrbranchesController;
import ru.grinncorp.departments.entity.Slrbranches;
import ru.grinncorp.departments.repository.SlrbranchesRepository;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 
 * @author agridin74
 *
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest(SlrbranchesController.class)
@ActiveProfiles("test")
public class SlrbranchesControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	SlrbranchesRepository repository;
	
	@Test
	void shouldGetASlrbranchesInJsonFormat() throws Exception {
		Slrbranches entity = setupSlrbranches();
		given(repository.findById(Long.valueOf(1))).willReturn(Optional.of(entity));
		
		mvc.perform(get("/slrbranches/1").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(jsonPath("$.id").value(1))
			.andExpect(jsonPath("$.smnemocode").value("Test"))
			.andExpect(jsonPath("$.snm").value("TestBranches"));
		
	}
	
	
	private Slrbranches setupSlrbranches() {
		Slrbranches entity = new Slrbranches();
		entity.setId(Long.valueOf(1));
		entity.setSmnemocode("Test");
		entity.setSnm("TestBranches");
		return entity;
	}

}
