package ru.grinncorp.slrkadr.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.grinncorp.slrkadr.controller.ResourceNotFoundException;
import ru.grinncorp.slrkadr.entity.Slrkadr;
import ru.grinncorp.slrkadr.repository.SlrkadrRepository;

@Service
public class SlrkadrServiceImpl implements SlrkadrService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SlrkadrRepository repository;
	
	@Override
	public Optional<Slrkadr> findById(Long id) {
		 
		return repository.findById(id);
		
	}

	@Override
	public List<Slrkadr> findAll() {
		 
		return repository.findAll();
	}

	@Override
	public Slrkadr create(Slrkadr entity) {
		Slrkadr newSlrkadr;
		newSlrkadr = repository.save(entity);
		log.info("+++ Create new slrkadr {}",newSlrkadr);
		return newSlrkadr;
	}

	@Override
	public Slrkadr update(Long slrkadrId,Slrkadr entity) {
		
		Optional<Slrkadr> slrkadr = repository.findById(slrkadrId);
		Slrkadr model = slrkadr.orElseThrow(
				() -> new ResourceNotFoundException("slrkadr "+ entity.getSfirstname()+" not found")
				);
		//model.setId(entity.getId());
		model.setLsex(entity.getLsex());
		model.setLworker(entity.getLworker());
		model.setSfirstname(entity.getSfirstname());
		model.setSsecondname(entity.getSsecondname());
		model.setSthirdname(entity.getSthirdname());
		model.setSnm(entity.getSnm());
		model.setDbirthdate(entity.getDbirthdate());
		model.setSbirthregion(entity.getSbirthregion());
		model.setSbirtharea(entity.getSbirtharea());
		model.setSbirthtown(entity.getSbirthtown());
		model.setSfirstnamerp(entity.getSfirstnamerp());
		model.setSsecondnamerp(entity.getSsecondnamerp());
		model.setSthirdnamerp(entity.getSthirdnamerp());
		model.setSfirstnamedp(entity.getSfirstnamedp());
		model.setSsecondnamedp(entity.getSsecondnamedp());
		model.setSthirdnamedp(entity.getSthirdnamedp());
		model.setSemail(entity.getSemail());
		model.setSinn(entity.getSinn());
		model.setSpfnumber(entity.getSpfnumber());
		model.setSpfcategory(entity.getSpfcategory());
		model.setSgni(entity.getSgni());
		model.setIdnationality(entity.getIdnationality());
		model.setIdlanguage(entity.getIdlanguage());
		model.setIdcountry(entity.getIdcountry());
		model.setIdcitizenship(entity.getIdcitizenship());
		model.setIdalientcategory(entity.getIdalientcategory());
		model.setCodct(entity.getCodct());
		log.info("+++ Saving slrkadr {} ",model);
		return repository.save(model);
	}

	@Override
	public void delete(Slrkadr entity) {
			log.info("+++ Delete slrkadr {}",entity);
			repository.delete(entity);
		
		
	}

	

}
