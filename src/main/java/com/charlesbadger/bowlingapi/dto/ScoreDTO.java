package com.charlesbadger.bowlingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ScoreDTO {
    private String player;
    private int chanceOnePins;
    private int chanceTwoPins;
    private int chanceThreePins;
    private int frame;
}


