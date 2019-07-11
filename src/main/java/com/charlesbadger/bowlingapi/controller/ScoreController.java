package com.charlesbadger.bowlingapi.controller;

import com.charlesbadger.bowlingapi.dto.ScoreDTO;
import com.charlesbadger.bowlingapi.model.Frame;
import com.charlesbadger.bowlingapi.model.Score;
import com.charlesbadger.bowlingapi.repository.PlayerNotFoundException;
import com.charlesbadger.bowlingapi.repository.ScoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController {
    private ScoreRepository scoreRepository;

    public ScoreController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @PostMapping("/score/{player}")
    public Frame addPlayerScore(@PathVariable String player, @RequestBody Frame frame) {
        scoreRepository.addPlayerScore(player, frame);
        return frame;
    }

    @GetMapping("/score")
    public List<Score> getScores() {
        return scoreRepository.getScores();
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String playerNotFoundHandler(PlayerNotFoundException ex) {
        return "Player not found";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String illegalArgumentHandler(IllegalArgumentException iae) {
        return iae.getMessage();
    }
}
