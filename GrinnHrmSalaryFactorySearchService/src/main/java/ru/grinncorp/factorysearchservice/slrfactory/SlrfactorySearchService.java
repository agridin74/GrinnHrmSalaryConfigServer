package ru.grinncorp.factorysearchservice.slrfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

/**
 * Сервис работы с объектом предприятие
 * @author agridin74
 * 
 */
@Service
public class SlrfactorySearchService {
	//логирование 
	private static Logger logger = LoggerFactory.getLogger(SlrfactorySearchService.class);
	
	//Заглушка для репозитария пока без доступа к БД
	private static Map< Long, Slrfactory> SlrfactoryRepository = null;
	
	static {
		Stream < String > slrfactoryStream = Stream.of("1, Factory1,FactoryLong1", 
													   "2, Factory2,FactoryLong2", 
													   "3, Factory3,FactoryLong3");
		SlrfactoryRepository = slrfactoryStream.map(slrfactoryStr -> {
			String[] info = slrfactoryStr.split(",");
			
			logger.info("... Add "+info+" ... ");
			
			return createSlrfactory(Long.valueOf(info[0]), info[1], info[2]);
		}).collect(Collectors.toMap(Slrfactory::getId, factory -> factory));
	}
	
	/**
	 * Создание сущности
	 * @param id Код записи
	 * @param snm Наименование  краткое
	 * @param slongname  Наименование подробное
	 * @return объект Slrfactory
	 */
	private static Slrfactory createSlrfactory(Long id, String snm, String slongname) {
		Slrfactory factory = new Slrfactory();
		factory.setId(id);
		factory.setSnm(snm);
		factory.setSlongname(slongname);
		
		logger.info("... Create factory - "+snm+" ... ");
		
		return factory;
	}
	
	/**
	 * Поиск предприятия
	 * @param id
	 * @return Slrfactory
	 */
	public Slrfactory findById(Long id) {
		logger.info("... Factory found for Id = "+id+" ...");
		return SlrfactoryRepository.get(id);
	}
	
	/**
	 * Список всех предприятий
	 * @return Collection < Slrfactory >
	 */
	public Collection < Slrfactory > findAll() {
		logger.info("... Find all factories ...");
		return SlrfactoryRepository.values();
	}

}
