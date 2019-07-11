package com.charlesbadger.bowlingapi.controller;

import com.charlesbadger.bowlingapi.dto.ScoreDTO;
import com.charlesbadger.bowlingapi.model.Player;
import com.charlesbadger.bowlingapi.repository.ScoreRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    ScoreRepository scoreRepository = ScoreRepository.getInstance();

    @PostMapping("/player")
    public Player createPlayer(@RequestBody Player player) {
        return scoreRepository.createPlayer(player);
    }

    @PostMapping("/player/{player}/score")
    public ScoreDTO addPlayerScore(@PathVariable String player, @RequestBody ScoreDTO scoreDTO) {
        scoreDTO.setPlayer(player);
        return scoreDTO;
    }

}
