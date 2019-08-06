package ru.grinncorp.paymentprize.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;



import ru.grinncorp.paymentprize.entity.Usrslrpaymentprize;
import ru.grinncorp.paymentprize.service.UsrslrpaymentprizeService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;



@ExtendWith(SpringExtension.class)
@WebMvcTest(UsrslrpaymentprizeController.class)
public class UsrslrpaymentprizeControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	UsrslrpaymentprizeService service;
	
	@Test
	void shouldGetAUsrslrpaymentprizeControlInJsonFormat() throws Exception{
		Usrslrpaymentprize entity = new Usrslrpaymentprize();
		entity.setId(1L);
		entity.setSnm("TEST");
		given(service.findById(1L)).willReturn(Optional.of(entity));
		mvc.perform(get("/usrslrpaymentprizes/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.id").value(1L))
		.andExpect(jsonPath("$.snm").value("TEST"));
	}

}
