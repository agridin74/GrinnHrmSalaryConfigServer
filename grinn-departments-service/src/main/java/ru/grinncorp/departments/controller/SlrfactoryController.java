package ru.grinncorp.departments.controller;

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
import ru.grinncorp.departments.entity.Slrfactory;
import ru.grinncorp.departments.repository.SlrfactoryRepository;
/**
 * 
 * @author agridin74
 *
 */

@RequestMapping("/slrfactorys")
@RestController
@Timed("grinncorp.slrfactory")
@RequiredArgsConstructor
@Slf4j
public class SlrfactoryController {
	
	private final SlrfactoryRepository slrfactoryRepository;
	
	/**
	 * Create Slrfactory
	 * @param slrfactory
	 * @return
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Slrfactory createSlrfactory(@Valid @RequestBody Slrfactory slrfactory) {
		return slrfactoryRepository.save(slrfactory);
	}
	
	/**
	 * Read single Slrfactory
	 * @param slrfactoryId
	 * @return
	 */
	@GetMapping(value = "/{slrfactoryId}")
	public Optional<Slrfactory> findSlrfactory(@PathVariable("slrfactoryId") Long slrfactoryId){
		return slrfactoryRepository.findById(slrfactoryId);
	}
	
	/**
	 * Read List of Slrfactorys
	 * @return
	 */
	@GetMapping
	public List<Slrfactory> findAll(){
		return slrfactoryRepository.findAll();
	}
	
	@PutMapping(value = "/{slrfactoryId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateSlrfactory(@PathVariable("slrfactoryId") Long slrfactoryId, 
								@Valid @RequestBody Slrfactory slrfactoryRequest) {
		final Optional<Slrfactory> slrfactory = slrfactoryRepository.findById(slrfactoryId);
		final Slrfactory slrfactoryModel = 
				slrfactory.orElseThrow(() -> new ResourceNotFoundException("Slrfactory " + 
																			slrfactoryId + " not found"));
		slrfactoryModel.setSnm(slrfactoryRequest.getSnm());
		slrfactoryModel.setSlongname(slrfactoryRequest.getSlongname());
		slrfactoryModel.setSokpo(slrfactoryRequest.getSokpo());
		slrfactoryModel.setSokonh(slrfactoryRequest.getSokonh());
		slrfactoryModel.setStown(slrfactoryRequest.getStown());
		slrfactoryModel.setSadress(slrfactoryRequest.getSadress());
		slrfactoryModel.setSadressf(slrfactoryRequest.getSadressf());
		slrfactoryModel.setSphone(slrfactoryRequest.getSphone());
		slrfactoryModel.setSinn(slrfactoryRequest.getSinn());
		slrfactoryModel.setSkpp(slrfactoryRequest.getSkpp());
		log.info("Saving slrfactory {}", slrfactoryModel);
		slrfactoryRepository.save(slrfactoryModel);
	}

}
