package com.charlesbadger.bowlingapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Score {
    String id;
    String playerNme;
    List<Frame> frames;
    int score;

}