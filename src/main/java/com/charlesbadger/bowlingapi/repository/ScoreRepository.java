package com.charlesbadger.bowlingapi.repository;

import com.charlesbadger.bowlingapi.model.Frame;
import com.charlesbadger.bowlingapi.model.Score;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ScoreRepository {
    private Map<String, Score> scoreMap = new HashMap<>();

    public List<Score> getScores() {
        //TODO sort by frame number
        return new ArrayList<>(scoreMap.values());
    }

    public Score createPlayer(Score score) {
        validatePlayerName(score.getPlayerName());
        var id = UUID.randomUUID().toString();
        score.setPlayerName(score.getPlayerName().trim());
        score.setId(id);
        List<Frame> frames = new ArrayList<>();
        score.setFrames(frames);
        scoreMap.put(score.getPlayerName(), score);
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

    public Frame addPlayerScore(String playerName, Frame frame) {
        var playerScore = scoreMap.get(playerName);
        if (playerScore == null) {
            throw new PlayerNotFoundException();
        }
        var playerFrames = playerScore.getFrames();

        if (playerFrames.size() < 10 && frame.getChanceThreePins() != 0) {
            throw new IllegalArgumentException("You don't get 3 chances in unless it's frame 10");
        }

        if (frame.getChanceOnePins() + frame.getChanceTwoPins() > 10 && playerFrames.size() < 10) {
            throw new IllegalArgumentException("There are only 10 pins");
        }


        if (frame.getChanceOnePins() + frame.getChanceTwoPins() == 10 ||
            playerFrames.isEmpty()) {
            frame.setFrameNumber(playerFrames.size() + 1);
            frame.setScore(frame.getChanceOnePins() + frame.getChanceTwoPins());
            playerFrames.add(frame);
            return frame;
        }

       // if current frame is neither strike nor spare,
        // loop through frames backwards, adding to a bonus score list  1 if strike, 2 if spare
        // stop if next number is not a strike or spare.
        // reverse bonus score list, loop through and calculate score.

        return frame;
    }
}
