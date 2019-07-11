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
        validatePlayerName(player.getName());
        var id = UUID.randomUUID().toString();
        player.setId(id);
        player.setScore(0);
        List<Frame> frames = new ArrayList<>();
        player.setFrames(frames);
        scoreMap.put(player.getName(), player);
        return player;
    }

    private void validatePlayerName(String name) {
        var playerList = new ArrayList<>(scoreMap.keySet());
        if (playerList.size() > 6) {
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
