package ru.grinncorp.paymentprize.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;

import ru.grinncorp.paymentprize.entity.Usrslrpaymentprize;
import ru.grinncorp.paymentprize.repository.UsrslrpaymentprizeRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsrslrpaymentprizeServiceTest {
	
	@InjectMocks
	private UsrslrpaymentprizeServiceImpl service;
	
	@Mock
	private UsrslrpaymentprizeRepository repository;
	
	@Test
	public void shouldCreateUsrslrpaymentprize() {
		Usrslrpaymentprize entity = new Usrslrpaymentprize();
		entity.setId(-1L);
		entity.setSnm("TEST-TEST");
		service.create(entity);
		verify(repository,times(1)).save(entity);
	}
	
	@Test
	public void shouldFailWhenEntityAlreadyExists() {
		assertThrows(IllegalArgumentException.class, () -> {
			Usrslrpaymentprize entity = new Usrslrpaymentprize();
			entity.setId(999L);
			entity.setSnm("TEST-TEST");
			when(repository.findById(entity.getId())).thenReturn(Optional.of(new Usrslrpaymentprize()));
			service.create(entity);
		});
	}

}
