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

import ru.grinncorp.departments.controller.SlrfactoryController;
import ru.grinncorp.departments.entity.Slrfactory;
import ru.grinncorp.departments.repository.SlrfactoryRepository;

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
@WebMvcTest(SlrfactoryController.class)
@ActiveProfiles("test")
public class SlrfactoryControllerTest {
	@Autowired
	MockMvc mvc;
	
	@MockBean
	SlrfactoryRepository repository;
	
	@Test
	void shouldGetSlrfactoryInJsonFormat() throws Exception{
		
		Slrfactory entity = setupSlrfactory();
		
		given(repository.findById(Long.valueOf(1))).willReturn(Optional.of(entity));
		mvc.perform(get("/slrfactorys/1").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(jsonPath("$.id").value(1))
			.andExpect(jsonPath("$.snm").value("TestFactory"))
			.andExpect(jsonPath("$.slongname").value("TestFactoryLong"));
		
		
		
	}
	
	private Slrfactory setupSlrfactory() {
		Slrfactory entity = new Slrfactory();
		entity.setId(Long.valueOf(1));
		entity.setSnm("TestFactory");
		entity.setSlongname("TestFactoryLong");
		return entity;
	}

}
