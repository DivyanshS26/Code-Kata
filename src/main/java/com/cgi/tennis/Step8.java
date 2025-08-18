package com.cgi.tennis;

import com.cgi.tennis.game.Player;
import com.cgi.tennis.game.PointName;

public class Step8 implements TennisGame {

    private final Player playerOne;
    private final Player playerTwo;

    public Step8(String playerOneName, String playerTwoName) {
        this.playerOne = new Player(playerOneName);
        this.playerTwo = new Player(playerTwoName);
    }

    public String getScore() {
        if (isNormalScore()) {
            return getNormalScore();
        }
        return getSpecialScore();
    }

    private boolean isNormalScore() {
        return playerOne.getPoint().lessThan(4) &&
                playerTwo.getPoint().lessThan(4) &&
                (playerOne.getPoint().value() + playerTwo.getPoint().value() != 6);
    }

    private String getNormalScore() {
        String playerOneScore = PointName.fromValue(playerOne.getPoint().value()).getName();
        if (playerOne.getPoint().equals(playerTwo.getPoint())) {
            return playerOneScore + "-All";
        }
        String playerTwoScore = PointName.fromValue(playerTwo.getPoint().value()).getName();
        return playerOneScore + "-" + playerTwoScore;
    }

    private String getSpecialScore() {
        if (playerOne.getPoint().equals(playerTwo.getPoint())) {
            return "Deuce";
        }
        return getAdvantageOrWin();
    }

    private String getAdvantageOrWin() {
        Player leadingPlayer = playerOne.getPoint().greaterThan(playerTwo.getPoint()) ? playerOne : playerTwo;
        if (isAdvantageScore()) {
            return "Advantage " + leadingPlayer.getName().name();
        }
        return "Win for " + leadingPlayer.getName().name();
    }

    private boolean isAdvantageScore() {
        return squareOfDifference() == 1;
    }

    private int squareOfDifference() {
        int difference = playerOne.getPoint().value() - playerTwo.getPoint().value();
        return difference * difference;
    }

    public void wonPoint(String playerName) {
        if (playerOne.getName().equals(playerName)) {
            playerOne.scorePoint();
        } else {
            playerTwo.scorePoint();
        }
    }
}

