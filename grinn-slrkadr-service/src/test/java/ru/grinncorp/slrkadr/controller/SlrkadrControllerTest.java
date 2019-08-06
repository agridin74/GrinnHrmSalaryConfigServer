package ru.grinncorp.slrkadr.controller;

import java.util.Optional;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import ru.grinncorp.slrkadr.entity.Slrkadr;
import ru.grinncorp.slrkadr.service.SlrkadrService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SlrkadrController.class)
public class SlrkadrControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	SlrkadrService service;
	
	@Test
	void shouldGetASlrkadrInJsonFormat() throws Exception{
		Slrkadr entity = new Slrkadr();
		entity.setId(1L);
		entity.setSnm("TEST");
		given(service.findById(1L)).willReturn(Optional.of(entity));
		mvc.perform(get("/slrkadrs/1").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(jsonPath("$.id").value(1L))
			.andExpect(jsonPath("$.snm").value("TEST"));
	}

}
