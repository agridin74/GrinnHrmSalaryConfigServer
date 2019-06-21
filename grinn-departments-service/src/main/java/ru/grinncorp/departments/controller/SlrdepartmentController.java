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
import ru.grinncorp.departments.entity.Slrdepartment;
import ru.grinncorp.departments.repository.SlrdepartmentRepository;

/**
 * 
 * @author agridin74
 *
 */
@RequestMapping("/slrdepartments")
@RestController
@Timed("grinncorp.slrdepartment")
@RequiredArgsConstructor
@Slf4j
public class SlrdepartmentController {
	
	private final SlrdepartmentRepository slrdepartmentRepository;
	
	/**
	 * 
	 * @param slrdepartment
	 * @return
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Slrdepartment createSlrdepartment(@Valid @RequestBody Slrdepartment slrdepartment) {
		return slrdepartmentRepository.save(slrdepartment);
	}
	
	/**
	 * Read single Slrdepartment
	 * @param slrdepartmentId
	 * @return
	 */
	@GetMapping(value = "/{slrdepartmentId}")
	public Optional<Slrdepartment> findSlrdepartment(@PathVariable("slrdepartmentId") Long slrdepartmentId){
		return slrdepartmentRepository.findById(slrdepartmentId);
	}
	
	/**
	 * Read List Slrdepartment
	 * @return
	 */
	@GetMapping
	public List<Slrdepartment> findAll(){
		return slrdepartmentRepository.findAll();
	}
	
	/**
	 * Update Slrdepartment
	 * @param slrdepartmentId
	 * @param slrdepartmentRequest
	 */
	@PutMapping(value = "/{slrdepartmentId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateSlrdepartment(@PathVariable("slrdepartmentId") Long slrdepartmentId,
					@Valid @RequestBody Slrdepartment slrdepartmentRequest) {
		final Optional<Slrdepartment> slrdepartment = slrdepartmentRepository.findById(slrdepartmentId);
		final Slrdepartment slrdepartmentModel = slrdepartment.orElseThrow(
				() -> new ResourceNotFoundException("Slrdepartment " + slrdepartmentId + " not found"));
		slrdepartmentModel.setSnm(slrdepartmentRequest.getSnm());
		slrdepartmentModel.setSnmlong(slrdepartmentRequest.getSnmlong());
		slrdepartmentModel.setSmnemocode(slrdepartmentRequest.getSmnemocode());
		slrdepartmentModel.setSlevel(slrdepartmentRequest.getSlevel());
		slrdepartmentModel.setDbegin(slrdepartmentRequest.getDbegin());
		slrdepartmentModel.setDend(slrdepartmentRequest.getDend());
		slrdepartmentModel.setDendclose(slrdepartmentRequest.getDendclose());
		log.info("Saving slrdepartment {}",slrdepartmentModel);
		slrdepartmentRepository.save(slrdepartmentModel);
		
	}
}
