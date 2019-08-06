package ru.grinncorp.paymentprize.service;

import java.util.List;
import java.util.Optional;

import ru.grinncorp.paymentprize.entity.Usrslrpaymentprize;

public interface UsrslrpaymentprizeService {
	
	public Optional<Usrslrpaymentprize> findById(Long id);
	
	public List<Usrslrpaymentprize> findAll();
	
	public Usrslrpaymentprize create(Usrslrpaymentprize entity);
	
	public Usrslrpaymentprize update(Long entityId, Usrslrpaymentprize entity);
	
	public void delete(Usrslrpaymentprize entity);

}
