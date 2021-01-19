package ru.ifmo.se.springweb.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.se.springweb.models.User;

public interface UserRepository extends CrudRepository<User, String> {
    User findByUsername(String username);
}
