package ru.ifmo.se.springweb.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.se.springweb.models.Points;
import ru.ifmo.se.springweb.models.User;

import java.util.List;

public interface PointRepository extends CrudRepository<Points, Long> {
    List<Points> getAllByUser(User user);
    void deleteAllByUser(User user);

}
