package com.charlesbadger.bowlingapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreDTO {
    private String player;
    private int frame;
    private int score;
}


