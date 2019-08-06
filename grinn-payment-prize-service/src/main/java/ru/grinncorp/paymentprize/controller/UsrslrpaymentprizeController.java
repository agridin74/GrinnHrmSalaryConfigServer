package ru.grinncorp.paymentprize.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.grinncorp.paymentprize.entity.Usrslrpaymentprize;
import ru.grinncorp.paymentprize.service.UsrslrpaymentprizeService;

@RequestMapping("/usrslrpaymentprizes")
@RestController
@Timed("grinncorp.usrslrpaymentprize")
@RequiredArgsConstructor
@Slf4j
public class UsrslrpaymentprizeController {
	
	private final UsrslrpaymentprizeService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usrslrpaymentprize createUsrslrpaymentprizeService(@Valid @RequestBody Usrslrpaymentprize entity) {
		return service.create(entity);
	}
	
	@GetMapping(value="/{entityId}")
	public Optional<Usrslrpaymentprize> findUsrslrpaymentprize(@PathVariable("entityId") Long entityId){
		return service.findById(entityId);
	}
	
	@GetMapping
	public List<Usrslrpaymentprize> findAll(){
		return service.findAll();
	}
	
	@PutMapping(value = "/{entityId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateUsrslrpaymentprize(@PathVariable("entityId") Long entityId,
			@Valid @RequestBody Usrslrpaymentprize entityRequest
			) {
		log.info("Saving UsrslrpaymentprizeController {}", entityRequest);
		service.update(entityId, entityRequest);
	}

}
