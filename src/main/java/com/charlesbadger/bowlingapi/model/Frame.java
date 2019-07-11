package com.charlesbadger.bowlingapi.model;

import lombok.Data;

@Data
public class Frame {
    String id;
    int frameNumber;
    int chanceOneScore;
    int chanceTwoScore;
    int chanceThreeScore;
}
