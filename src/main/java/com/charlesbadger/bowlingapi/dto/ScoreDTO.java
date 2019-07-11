package com.charlesbadger.bowlingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ScoreDTO {
    private String player;
    private int frame;
    private int chance;
    private int score;
}


