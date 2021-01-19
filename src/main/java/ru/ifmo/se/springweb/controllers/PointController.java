package ru.ifmo.se.springweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.se.springweb.models.PointDTO;
import ru.ifmo.se.springweb.models.Points;
import ru.ifmo.se.springweb.services.PointService;
import ru.ifmo.se.springweb.services.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
public class PointController {
    private final PointService pointService;
    private final UserService userService;

    @Autowired
    public PointController(PointService pointService, UserService userService) {
        this.pointService = pointService;
        this.userService = userService;
    }

    @GetMapping("/points")
    public List<Points> getAll(Principal user) {
        return pointService.getPointsByUsername(userService.findByUsername(user.getName()));
    }

    @PostMapping("/points")
    public PointDTO addPoint(@RequestBody @Valid PointDTO point, Principal user) {
        Points points = new Points(point);
        points.setReqTime(LocalDateTime.now());
        boolean hit = points.calculate();
        points.setResult(hit);
        point.setResult(hit);
        points.setUser(userService.findByUsername(user.getName()));
        pointService.addPoint(points);
        return point;
    }

    @DeleteMapping("/points")
    public void deleteAll(Principal user) {
        pointService.deletePointsByUser(userService.findByUsername(user.getName()));
    }
}

