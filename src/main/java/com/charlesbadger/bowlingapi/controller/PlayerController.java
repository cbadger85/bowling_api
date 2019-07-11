package com.charlesbadger.bowlingapi.controller;

import com.charlesbadger.bowlingapi.model.Score;
import com.charlesbadger.bowlingapi.repository.ScoreRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    private ScoreRepository scoreRepository;

    public PlayerController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @PostMapping("/player")
    public Score createPlayer(@RequestBody Score player) {
        return scoreRepository.createPlayer(player);
    }

}
