package com.charlesbadger.bowlingapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    @GetMapping("/{player}/score")
    public String getPlayerScore(@PathVariable String player,
                          @RequestParam String frame,
                          @RequestParam String score) {
        return "Player " + player + " frame " + frame + " score " + score;
    }
}
