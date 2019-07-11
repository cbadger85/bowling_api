package com.charlesbadger.bowlingapi.controller;

import com.charlesbadger.bowlingapi.DTO.ScoreDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    @GetMapping("/{player}/score")
    public ScoreDTO getPlayerScore(@PathVariable String player,
                          @RequestParam int frame,
                          @RequestParam int score) {
        var scoreDTO = new ScoreDTO(player, frame, score);
        return scoreDTO;
    }
}
