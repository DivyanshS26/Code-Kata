package com.cgi.tennis;

import com.cgi.tennis.game.PlayerName;
import com.cgi.tennis.game.Point;
import com.cgi.tennis.game.PointName;

public class Step5 implements TennisGame {

    private Point p1;
    private Point p2;
    private PlayerName p1N;
    private PlayerName p2N;

    public Step5(String p1N, String p2N) {
        this.p1N = new PlayerName(p1N);
        this.p2N = new PlayerName(p2N);
        this.p1 = new Point(0);
        this.p2 = new Point(0);
    }

    public String getScore() {
        if (isNormalScore()) {
            return getNormalScore();
        }
        return getSpecialScore();
    }

    private boolean isNormalScore() {
        return p1.lessThan(4) && p2.lessThan(4) && (p1.value() + p2.value() != 6);
    }

    private String getNormalScore() {
        PointName p1PointName = PointName.fromValue(p1.value());
        String p1Score = p1PointName.getName();

        if (p1.equals(p2)) {
            return p1Score + "-All";
        }

        PointName p2PointName = PointName.fromValue(p2.value());
        String p2Score = p2PointName.getName();

        return p1Score + "-" + p2Score;
    }

    private String getSpecialScore() {
        if (p1.equals(p2)) {
            return "Deuce";
        }
        return getAdvantageOrWin();
    }

    private String getAdvantageOrWin() {
        PlayerName player = p1.greaterThan(p2) ? p1N : p2N;
        if (isAdvantageScore()) {
            return "Advantage " + player.name();
        }
        return "Win for " + player.name();
    }

    private boolean isAdvantageScore() {
        return squareOfDifference() == 1;
    }

    private int squareOfDifference() {
        int diff = p1.value() - p2.value();
        return diff * diff;
    }

    public void wonPoint(String playerName) {
        if (p1N.equals(playerName)) {
            p1 = p1.add(1);
            return;
        }
        p2 = p2.add(1);
    }
}

