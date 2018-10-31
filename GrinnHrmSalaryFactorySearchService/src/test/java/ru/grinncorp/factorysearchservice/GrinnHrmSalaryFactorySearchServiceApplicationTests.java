package ru.grinncorp.factorysearchservice;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import ru.grinncorp.factorysearchservice.slrfactory.Slrfactory;
import ru.grinncorp.factorysearchservice.slrfactory.SlrfactorySearchController;
import ru.grinncorp.factorysearchservice.slrfactory.SlrfactorySearchService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author agridin74
 * Тестирование подлючения junit5
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(SlrfactorySearchController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
@ActiveProfiles("test")
public class GrinnHrmSalaryFactorySearchServiceApplicationTests {

	@Autowired
	MockMvc mvc;
	
	@MockBean
	SlrfactorySearchService slrfactorySearchService;
	
	/**
	 * Тестирование в формате получение результатов в формате JSON
	 * @throws Exception
	 */
	@Test
	void shouldGetASlrfactoryInJSonFormat() throws Exception{
		Slrfactory slrfactory = setupSlrfactory();
		given(slrfactorySearchService.findById(Long.valueOf(2))).willReturn(slrfactory);
		mvc.perform(get("/slrfactory/find/2").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(jsonPath("$.id").value(2))
			.andExpect(jsonPath("$.snm").value("TestFactory"))
			.andExpect(jsonPath("$.slongname").value("TestLongFactory"));
	}
	
	
	
	/**
	 * создание фиктивного предприятия для тестирования
	 * @return Slrfactory
	 */
	private Slrfactory setupSlrfactory() {
		Slrfactory slrfactory = new Slrfactory();
		slrfactory.setId( Long.valueOf(2));
		slrfactory.setSnm("TestFactory");
		slrfactory.setSlongname("TestLongFactory");
		return slrfactory;
	}

}
