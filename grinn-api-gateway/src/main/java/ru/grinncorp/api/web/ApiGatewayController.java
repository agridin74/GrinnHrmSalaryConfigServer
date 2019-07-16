package ru.grinncorp.api.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.grinncorp.api.application.DepartmentsServiceClient;
import ru.grinncorp.api.dto.Slrdepartment;
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class ApiGatewayController {
	
	private final DepartmentsServiceClient departmentsServiceClient;
	
	@GetMapping(value = "slrdepartments/{depId}")
	public Slrdepartment getSlrdepartment(final @PathVariable Long depId) {
		final Slrdepartment dep = departmentsServiceClient.getSlrdepartment(depId);
		return dep;
	}
	
	@GetMapping(value = "slrdepartments/")
	public List<Slrdepartment> getAll() {
		List<Slrdepartment> deps = departmentsServiceClient.findAll();
		return deps;
	}

}
