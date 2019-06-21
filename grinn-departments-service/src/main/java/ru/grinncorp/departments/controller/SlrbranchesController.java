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
import ru.grinncorp.departments.entity.Slrbranches;
import ru.grinncorp.departments.repository.SlrbranchesRepository;

/**
 * 
 * @author agridin74
 *
 */
@RequestMapping("/slrbranches")
@RestController
@Timed("grinncorp.slrbranches")
@RequiredArgsConstructor
@Slf4j
public class SlrbranchesController {
	
	private final SlrbranchesRepository slrbranchesRepository;
	
	/**
	 * Create Slrbranches
	 * @param slrbranches
	 * @return
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Slrbranches createSlrbranches(@Valid @RequestBody Slrbranches slrbranches) {
		return slrbranchesRepository.save(slrbranches);
	}
	
	/**
	 * Read single Slrbranches
	 * @param slrbranchesId
	 * @return 
	 */
	@GetMapping(value="/{slrbranchesId}")
	public Optional<Slrbranches> findSlrbranches(@PathVariable("slrbranchesId") Long slrbranchesId){
		return slrbranchesRepository.findById(slrbranchesId);
	}
	
	/**
	 * Read List of Slrbranches
	 * @return
	 */
	@GetMapping
	public List<Slrbranches> findAll(){
		return slrbranchesRepository.findAll();
	}
	
	/**
	 * Update Slrbranches
	 * @param slrbranchesId
	 * @param slrbranchesRequest
	 */
	@PutMapping(value = "/{slrbranchesId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateSlrbranches(@PathVariable("slrbranchesId") Long slrbranchesId, 
			@Valid @RequestBody Slrbranches slrbranchesRequest) {
		final Optional<Slrbranches> slrbranches = slrbranchesRepository.findById(slrbranchesId);
		final Slrbranches slrbranchesModel = slrbranches.orElseThrow(
				() -> new ResourceNotFoundException("Slrbranches " + slrbranchesId + "not found"));
		// рекомендовано использовать MapStruct
		slrbranchesModel.setSnm(slrbranchesRequest.getSnm());
		slrbranchesModel.setSmnemocode(slrbranchesRequest.getSmnemocode());
		slrbranchesModel.setIdfactory(slrbranchesRequest.getIdfactory());
		log.info("Saving slrbranches {}", slrbranchesModel);
		slrbranchesRepository.save(slrbranchesModel);
	}

}
