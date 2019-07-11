package com.charlesbadger.bowlingapi.controller;

import com.charlesbadger.bowlingapi.dto.ScoreDTO;
import com.charlesbadger.bowlingapi.model.Score;
import com.charlesbadger.bowlingapi.repository.ScoreRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController {
    ScoreRepository scoreRepository = ScoreRepository.getInstance();

    @PostMapping("/score/{player}")
    public ScoreDTO addPlayerScore(@PathVariable String player, @RequestBody ScoreDTO scoreDTO) {
        scoreDTO.setPlayer(player);
        return scoreDTO;
    }


    @GetMapping("/score")
    public List<Score> getScores() {
        return scoreRepository.getScores();
    }
}
