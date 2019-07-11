package com.charlesbadger.bowlingapi.repository;

import com.charlesbadger.bowlingapi.model.Frame;
import com.charlesbadger.bowlingapi.model.Player;

import java.util.*;

public class ScoreRepository {
    private static ScoreRepository single_instance = null;
    private Map<String, Player> scoreMap = new HashMap<>();

    private ScoreRepository() {}

    public static ScoreRepository getInstance()
    {
        if (single_instance == null)
            single_instance = new ScoreRepository();

        return single_instance;
    }

    public List<Player> getScores() {
        return new ArrayList<>(scoreMap.values());
    }

    public Player createPlayer(Player player) {
        //TODO validate player input
        var id = UUID.randomUUID().toString();
        player.setId(id);
        player.setScore(0);
        List<Frame> frames = new ArrayList<>();
        player.setFrames(frames);
        scoreMap.put(player.getName(), player);
        return player;
    }
}
