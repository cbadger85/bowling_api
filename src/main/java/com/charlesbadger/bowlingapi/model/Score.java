package com.charlesbadger.bowlingapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Score {
    String id;
    String playerName;
    List<Frame> frames;

    public int getTotalScore() {
        return 4;
    }

}
