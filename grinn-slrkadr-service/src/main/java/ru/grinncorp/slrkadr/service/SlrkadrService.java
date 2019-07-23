package ru.grinncorp.slrkadr.service;

import java.util.List;
import java.util.Optional;

import ru.grinncorp.slrkadr.entity.Slrkadr;

/**
 * Работа с физлицами
 * @author agridin74
 * 
 */
public interface SlrkadrService {

	/**
	 * Поиск физ.лица  по Id
	 * @param id
	 * @return
	 */
	public Optional<Slrkadr> findById(Long id);

	
	/**
	 * Список  физ.лица
	 * @return
	 */
	public List<Slrkadr> findAll();

	/** создать физ.лицо
	 * @param entity
	 * @return
	 */
	public Slrkadr create(Slrkadr entity);

	/**
	 *  Обновить физ.лицо
	 * @param entity
	 * @return
	 */
	public Slrkadr update(Long slrkadrId,Slrkadr entity);

	/** 
	 * удалить физ лицо
	 * @param entity
	 */
	void delete(Slrkadr entity);

}
