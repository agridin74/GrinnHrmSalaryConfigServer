package ru.grinncorp.departments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.grinncorp.departments.entity.Slrfactory;
/**
 * Repository class for <code>Slrfactory</code> domain objects All method names are
 * compliant with Spring Data naming conventions so interface can easily be extended
 * for Spring Data.
 * @author agridin74
 *
 */

public interface SlrfactoryRepository  extends JpaRepository<Slrfactory, Long>{

}
