package com.charlesbadger.bowlingapi.controller;

import com.charlesbadger.bowlingapi.model.Player;
import com.charlesbadger.bowlingapi.repository.ScoreRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoreController {
    ScoreRepository scoreRepository = ScoreRepository.getInstance();


    @GetMapping("/score")
    public List<Player> getScores() {
        return scoreRepository.getScores();
    }
}
