package ru.ifmo.se.springweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ifmo.se.springweb.models.Points;
import ru.ifmo.se.springweb.models.User;
import ru.ifmo.se.springweb.repositories.PointRepository;

import java.util.List;

@Service
public class PointService {
    private final PointRepository pointRepository;

    @Autowired
    public PointService(PointRepository pointRepository){
        this.pointRepository = pointRepository;
    }

    @Transactional
    public List<Points> getPointsByUsername(User user) {
        return pointRepository.getAllByUser(user);
    }

    @Transactional
    public void deletePointsByUser(User user) {
        pointRepository.deleteAllByUser(user);
    }

    @Transactional
    public void addPoint(Points point) {
        pointRepository.save(point);
    }
}