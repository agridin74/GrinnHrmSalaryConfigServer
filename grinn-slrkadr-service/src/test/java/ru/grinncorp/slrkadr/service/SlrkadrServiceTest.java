package ru.grinncorp.slrkadr.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
@Tag("Service")
public class SlrkadrServiceTest {

	@InjectMocks
	private SlrkadrServiceImpl slrkadrService;
	
	@Mock
	private SlrkadrRepository repository;
	
	@BeforeEach
	public void setUp() throws Exception {
		//stub
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		
	}
	
	@Test
	@DisplayName("Create Slrkadr")
	public void shouldCreateSlrkadr() {
		Slrkadr slrkadr = new Slrkadr();
		slrkadr.setId(1L);
		slrkadr.setSnm("TestKadr");
		slrkadrService.create(slrkadr);
		verify(repository,times(1)).save(slrkadr);
	}
	
	@Test
	@DisplayName("Throws exception if Slrkadr Already Exists\n" + 
			"exist")
	public void shouldFailWhenSlrkadrAlreadyExists() {
		assertThrows(IllegalArgumentException.class, () -> {
			Slrkadr  slrkadr = new Slrkadr();
			slrkadr.setId(9999L);
			slrkadr.setSnm("TestKadr");
			when(repository.findById(slrkadr.getId())).thenReturn(Optional.of(new Slrkadr()));
			slrkadrService.create(slrkadr);
		} );
	}
	
	@Disabled
	@Test
	@DisplayName("Throws exception if slrkadr with given email does not exist")
	void Should_throwException_When_SlrkadrDoesNotExist() {
		fail("Not yet implemented");
	}
	
	@Disabled
	@Test
	@DisplayName("Throws exception if slrkadr with given snm is not found in the database")
	void Should_throwException_When_UnmatchingSlrkadrCredentialsFound() {
		fail("Not yet implemented");
	} 
}
