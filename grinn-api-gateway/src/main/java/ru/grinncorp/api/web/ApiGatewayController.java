package ru.grinncorp.api.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.grinncorp.api.application.DepartmentsServiceClient;
import ru.grinncorp.api.dto.Slrdepartment;

@RestController
@RequiredArgsConstructor
public class ApiGatewayController {
	
	private final DepartmentsServiceClient departmentsServiceClient;
	
	@GetMapping(value = "slrdepartments/{depId}")
	public Slrdepartment getSlrdepartment(final @PathVariable Long depId) {
		final Slrdepartment dep = departmentsServiceClient.getSlrdepartment(depId);
		return dep;
	}

}
