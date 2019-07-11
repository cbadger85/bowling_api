package com.charlesbadger.bowlingapi.model;

import lombok.Data;

@Data
public class Frame {
    int frameNumber;
    int chanceOnePins;
    int chanceTwoPins;
    int chanceThreePins;
    int score;
}
