package ru.grinncorp.api.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.grinncorp.api.application.DepartmentsServiceClient;
import ru.grinncorp.api.application.SlrkadrServiceClient;
import ru.grinncorp.api.application.UsrslrpaymentprizeServiceClient;
import ru.grinncorp.api.dto.Slrdepartment;
import ru.grinncorp.api.dto.Slrkadr;
import ru.grinncorp.api.dto.Usrslrpaymentprize;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class ApiGatewayController {
	
	private final DepartmentsServiceClient departmentsServiceClient;
	
	private final SlrkadrServiceClient slrkadrServiceClient;
	
	private final UsrslrpaymentprizeServiceClient usrslrpaymentprizeServiceClient;
	
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
	
	
	@GetMapping(value = "slrkadrs/{entityId}")
	public Slrkadr getSlrkadr(final @PathVariable Long entityId) {
		final Slrkadr kadr = slrkadrServiceClient.getSlrkadr(entityId);
		return kadr;
	}
	
	@GetMapping(value = "slrkadrs/")
	public List<Slrkadr> getKadrAll(){
		List<Slrkadr> kadrs = slrkadrServiceClient.findAll();
		return kadrs;
	}
	
	@GetMapping(value = "usrslrpaymentprizes/{entityId}")
	public Usrslrpaymentprize getUsrslrpaymentprize(final @PathVariable Long entityId) {
		final Usrslrpaymentprize payment = usrslrpaymentprizeServiceClient.getUsrslrpaymentprize(entityId);
		return payment;
	}
	
	@GetMapping(value = "usrslrpaymentprizes/")
	public List<Usrslrpaymentprize> getUsrslrpaymentprizeAll(){
		List<Usrslrpaymentprize> payments = usrslrpaymentprizeServiceClient.findAll();
		return payments;
	}

}
