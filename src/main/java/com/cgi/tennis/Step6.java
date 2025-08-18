package com.cgi.tennis;

import com.cgi.tennis.game.PlayerName;
import com.cgi.tennis.game.Point;
import com.cgi.tennis.game.PointName;

public class Step6 implements TennisGame {

    private Point playerOnePoint;
    private Point playerTwoPoint;
    private final PlayerName playerOneName;
    private final PlayerName playerTwoName;

    public Step6(String playerOne, String playerTwo) {
        this.playerOneName = new PlayerName(playerOne);
        this.playerTwoName = new PlayerName(playerTwo);
        this.playerOnePoint = new Point(0);
        this.playerTwoPoint = new Point(0);
    }

    public String getScore() {
        if (isNormalScore()) {
            return getNormalScore();
        }
        return getSpecialScore();
    }

    private boolean isNormalScore() {
        return playerOnePoint.lessThan(4) &&
                playerTwoPoint.lessThan(4) &&
                (playerOnePoint.value() + playerTwoPoint.value() != 6);
    }

    private String getNormalScore() {
        PointName playerOnePointName = PointName.fromValue(playerOnePoint.value());
        String playerOneScore = playerOnePointName.getName();

        if (playerOnePoint.equals(playerTwoPoint)) {
            return playerOneScore + "-All";
        }

        PointName playerTwoPointName = PointName.fromValue(playerTwoPoint.value());
        String playerTwoScore = playerTwoPointName.getName();

        return playerOneScore + "-" + playerTwoScore;
    }

    private String getSpecialScore() {
        if (playerOnePoint.equals(playerTwoPoint)) {
            return "Deuce";
        }
        return getAdvantageOrWin();
    }

    private String getAdvantageOrWin() {
        PlayerName leadingPlayer =
                playerOnePoint.greaterThan(playerTwoPoint) ? playerOneName : playerTwoName;
        if (isAdvantageScore()) {
            return "Advantage " + leadingPlayer.name();
        }
        return "Win for " + leadingPlayer.name();
    }

    private boolean isAdvantageScore() {
        return squareOfDifference() == 1;
    }

    private int squareOfDifference() {
        int difference = playerOnePoint.value() - playerTwoPoint.value();
        return difference * difference;
    }

    public void wonPoint(String playerName) {
        if (playerOneName.equals(playerName)) {
            playerOnePoint = playerOnePoint.add(1);
        } else {
            playerTwoPoint = playerTwoPoint.add(1);
        }
    }
}

