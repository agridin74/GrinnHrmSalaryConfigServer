package ru.grinncorp.factorysearchservice.slrfactory;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST API контроллер Slrfactory
 * @author agridin74
 *
 */
@RefreshScope
@RestController
@RequestMapping("/slrfactory")
public class SlrfactorySearchController {
	
	private static Logger logger = LoggerFactory.getLogger(SlrfactorySearchService.class);
	
	@Autowired
	SlrfactorySearchService slrfactorySearchService;
	
	/**
	 * Поиск предприятия по коду
	 * @param id
	 * @return Slrfactory
	 */
	@RequestMapping("/find/{id}")
	public Slrfactory findById(@PathVariable Long id) {
		logger.info("... <Controller> factory found for Id = " + id + " ... ");
		return slrfactorySearchService.findById(id);
	}
	
	/**
	 * Список всех предприятий
	 * @return Collection < Slrfactory >
	 */
	@RequestMapping("/findAll")
	public Collection < Slrfactory > findAll(){
		logger.info("... <Controller>  find all factories ...");
		return slrfactorySearchService.findAll();
	}

}
