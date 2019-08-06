package ru.grinncorp.paymentprize.repository;

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

import ru.grinncorp.paymentprize.entity.Usrslrpaymentprize;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UsrslrpaymentprizeRepositoryTest {
	
	private static final Long ENTITY_ID = 999L;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private UsrslrpaymentprizeRepository repository;
	
	@Test
	public void injectedComponentsAreNotNull() {
		assertThat(dataSource).isNotNull();
		assertThat(jdbcTemplate).isNotNull();
		assertThat(entityManager).isNotNull();
		assertThat(repository).isNotNull();
	}
	
	@Test
	public void shouldSaveAndFindUsrslrpaymentprizeBySnm() {
		Usrslrpaymentprize entity = new Usrslrpaymentprize();

		entity.setSnm("Test"+ENTITY_ID);
		entity=repository.save(entity);
		Optional<Usrslrpaymentprize> findEntity = repository.findById(entity.getId());

		assertTrue(findEntity.isPresent());
		assertEquals(entity.getId(), findEntity.get().getId());
		assertEquals(entity.getSnm(), findEntity.get().getSnm());
	}
}
