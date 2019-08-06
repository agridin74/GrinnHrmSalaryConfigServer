package ru.grinncorp.slrkadr.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ru.grinncorp.slrkadr.entity.Slrkadr;
import ru.grinncorp.slrkadr.repository.SlrkadrRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SlrkadrServiceTest {

	@InjectMocks
	private SlrkadrServiceImpl slrkadrService;
	
	@Mock
	private SlrkadrRepository repository;
	
	@Test
	public void shouldCreateSlrkadr() {
		Slrkadr slrkadr = new Slrkadr();
		slrkadr.setId(1L);
		slrkadr.setSnm("TestKadr");
		slrkadrService.create(slrkadr);
		verify(repository,times(1)).save(slrkadr);
	}
	
	@Test
	public void shouldFailWhenSlrkadrAlreadyExists() {
		assertThrows(IllegalArgumentException.class, () -> {
			Slrkadr  slrkadr = new Slrkadr();
			slrkadr.setId(9999L);
			slrkadr.setSnm("TestKadr");
			when(repository.findById(slrkadr.getId())).thenReturn(Optional.of(new Slrkadr()));
			slrkadrService.create(slrkadr);
		} );
	}
}
