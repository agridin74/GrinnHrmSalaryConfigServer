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

import ru.grinncorp.departments.controller.SlrdepartmentController;
import ru.grinncorp.departments.entity.Slrdepartment;
import ru.grinncorp.departments.repository.SlrdepartmentRepository;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SlrdepartmentController.class)
@ActiveProfiles("test")
public class SlrdepartmentControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	SlrdepartmentRepository repository;
	
	@Test
	void shouldGetASlrdepartmentInJsonFormat() throws Exception {
		Slrdepartment entity = setupSlrdepartment();
		given(repository.findById(Long.valueOf(1))).willReturn(Optional.of(entity));
		mvc.perform(get("/slrdepartments/1").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(jsonPath("$.id").value(1))
			.andExpect(jsonPath("$.snm").value("Test"))
			.andExpect(jsonPath("$.snmlong").value("TestDepartment"));
		
	}
	
	private Slrdepartment setupSlrdepartment() {
		Slrdepartment entity = new Slrdepartment();
		entity.setId(Long.valueOf(1));
		entity.setSnm("Test");
		entity.setSnmlong("TestDepartment");
		return entity;
	}
}
