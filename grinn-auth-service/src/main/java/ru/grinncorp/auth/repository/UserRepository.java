package ru.grinncorp.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.grinncorp.auth.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
