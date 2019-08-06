package ru.grinncorp.paymentprize.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.grinncorp.paymentprize.controller.ResourceNotFoundException;
import ru.grinncorp.paymentprize.entity.Usrslrpaymentprize;
import ru.grinncorp.paymentprize.repository.UsrslrpaymentprizeRepository;


@Service
public class UsrslrpaymentprizeServiceImpl implements UsrslrpaymentprizeService{

	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UsrslrpaymentprizeRepository repository;
	
	@Override
	public Optional<Usrslrpaymentprize> findById(Long id) {
		
		return repository.findById(id);
	}

	@Override
	public List<Usrslrpaymentprize> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Usrslrpaymentprize create(Usrslrpaymentprize entity) {
		Optional<Usrslrpaymentprize> existing = repository.findById(entity.getId());
		existing.ifPresent(a -> {
			throw new IllegalArgumentException("Usrslrpaymentprize alredy exists: " + a.getId());
		});
		Usrslrpaymentprize newUsrslrpaymentprize = repository.save(entity);
		log.info("Create new Usrslrpaymentprize {}", newUsrslrpaymentprize);
		return newUsrslrpaymentprize;
	}

	@Override
	public Usrslrpaymentprize update(Long entityId, Usrslrpaymentprize entity) {
		Optional<Usrslrpaymentprize> usrslrpaymentprize = repository.findById(entityId);
		Usrslrpaymentprize model = usrslrpaymentprize.orElseThrow(
				() -> new ResourceNotFoundException("Usrslrpaymentprize " + entity.getSnm()+" not found")
				);
		model.setId(entity.getId()); 
		model.setIdfactory(entity.getIdfactory()); 
		model.setIdbranches(entity.getIdbranches());   
		model.setIddepartment(entity.getIddepartment()); 
		model.setSnm(entity.getSnm()); 
		model.setIdkadr(entity.getIdkadr()); 
		model.setIdincome(entity.getIdincome());
		model.setNmoney(entity.getNmoney());
		model.setNmoneyvichet(entity.getNmoneyvichet());
		model.setNtaxprc(entity.getNtaxprc());
		model.setNtaxmoney(entity.getNtaxmoney());
		model.setDperiod(entity.getDperiod());
		model.setDperiodfrom(entity.getDperiodfrom());
		model.setDperiodfromuser(entity.getDperiodfromuser());
		model.setDfactpayed(entity.getDfactpayed());
		model.setDperiodtax(entity.getDperiodtax());
		model.setDpayofftax(entity.getDpayofftax());
		model.setDtimelimittax(entity.getDtimelimittax());
		model.setSremark(entity.getSremark());
		model.setIdcreator(entity.getIdcreator());
		model.setIdeditor(entity.getIdeditor());
		model.setDcreatedatetime(entity.getDcreatedatetime());
		model.setDeditdatetime(entity.getDeditdatetime());
		log.info("Saving Usrslrpaymentprize {}", model);
		return repository.save(model);
	}

	@Override
	public void delete(Usrslrpaymentprize entity) {
		log.info("Delete Usrslrpaymentprize {}", entity);
		repository.delete(entity);
		
	}

}
