package ru.grinncorp.slrkadr.controller;
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
import ru.grinncorp.slrkadr.entity.Slrkadr;
import ru.grinncorp.slrkadr.service.SlrkadrService;

@RequestMapping("/slrkadrs")
@RestController
@Timed("grinncorp.slrkadr")
@RequiredArgsConstructor
@Slf4j
public class SlrkadrController {
	
	private final SlrkadrService service;
	
	/**
	 * Create entity
	 * @param slrkadr
	 * @return
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Slrkadr createSlrkadr(@Valid @RequestBody Slrkadr slrkadr) {
		return service.create(slrkadr);
	}
	
	/**
	 * Read single entity
	 * @param slrkadrId
	 * @return
	 */
	@GetMapping(value ="/{slrkadrId}")
	public Optional<Slrkadr>  findSlrkadr(@PathVariable("slrkadrId") Long slrkadrId){
		return service.findById(slrkadrId);
	}
	
	/**
	 * Read List entity
	 * @return
	 */
	@GetMapping
	public List<Slrkadr> findAll(){
		return service.findAll();
	}
	
	/**
	 * Update entity
	 * @param slrkadrId
	 * @param slrkadrRequest
	 */
	@PutMapping(value = "/{slrkadrId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateSlrkadr(@PathVariable("slrkadrId") Long slrkadrId,
			@Valid @RequestBody Slrkadr slrkadrRequest) {
		log.info("+++ Saving SlrkadrController {} ",slrkadrRequest);
		service.update(slrkadrId,slrkadrRequest);
	}

}
