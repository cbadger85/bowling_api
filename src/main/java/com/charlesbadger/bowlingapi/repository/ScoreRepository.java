package com.charlesbadger.bowlingapi.repository;

import com.charlesbadger.bowlingapi.model.Frame;
import com.charlesbadger.bowlingapi.model.Score;

import java.util.*;

public class ScoreRepository {
    private static ScoreRepository singleInstance = null;
    private Map<String, Score> scoreMap = new HashMap<>();

    private ScoreRepository() {}

    public static ScoreRepository getInstance()
    {
        if (singleInstance == null)
            singleInstance = new ScoreRepository();

        return singleInstance;
    }

    public List<Score> getScores() {
        return new ArrayList<>(scoreMap.values());
    }

    public Score createPlayer(Score score) {
        validatePlayerName(score.getPlayerNme());
        var id = UUID.randomUUID().toString();
        score.setPlayerNme(score.getPlayerNme().trim());
        score.setId(id);
        score.setScore(0);
        List<Frame> frames = new ArrayList<>();
        score.setFrames(frames);
        scoreMap.put(score.getPlayerNme(), score);
        return score;
    }

    private void validatePlayerName(String name) {
        var playerList = new ArrayList<>(scoreMap.keySet());
        if (playerList.size() >= 6) {
            throw new IllegalArgumentException("You can only have 6 players");
        }
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("You must enter a player name");
        }
        if (playerList.contains(name)) {
            throw new IllegalArgumentException("That player name already exists");
        }
    }
}
