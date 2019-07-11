package com.charlesbadger.bowlingapi.controller;

import com.charlesbadger.bowlingapi.model.Score;
import com.charlesbadger.bowlingapi.repository.ScoreRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    ScoreRepository scoreRepository = ScoreRepository.getInstance();

    @PostMapping("/player")
    public Score createPlayer(@RequestBody Score player) {
        return scoreRepository.createPlayer(player);
    }

}
