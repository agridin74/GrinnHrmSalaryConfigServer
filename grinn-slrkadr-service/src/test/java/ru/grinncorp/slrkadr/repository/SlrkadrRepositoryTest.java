package ru.grinncorp.slrkadr.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ru.grinncorp.slrkadr.entity.Slrkadr;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SlrkadrRepositoryTest {
	
	private static final Long SLRKADR_ID = 1L;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private SlrkadrRepository slrkadrRepository;
	
	@Test
	void injectedComponentsAreNotNull() {
		assertThat(dataSource).isNotNull();
		assertThat(jdbcTemplate).isNotNull();
		assertThat(entityManager).isNotNull();
		assertThat(slrkadrRepository).isNotNull();
	}
	
	@Test
	public void shouldSaveAndFindSlrkadrBySnm() {
		Slrkadr slrkadr = new Slrkadr();
		slrkadr.setId(SLRKADR_ID);
		slrkadr.setSnm("TestKadr");
		slrkadrRepository.save(slrkadr);
		
		Optional<Slrkadr> findSlrkadr = slrkadrRepository.findById(SLRKADR_ID);
		
		assertTrue(findSlrkadr.isPresent());
		assertEquals(slrkadr.getId(), findSlrkadr.get().getId());
		assertEquals(slrkadr.getSnm(), findSlrkadr.get().getSnm());
	}

}
