package com.cgi.tennis;

public class Step2 implements TennisGame {

    private int p1;
    private int p2;
    private String p1N;
    private String p2N;

    public Step2(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        if (isNormalScore()) {
            return getNormalScore();
        }
        return getSpecialScore();
    }

    private boolean isNormalScore() {
        return p1 < 4 && p2 < 4 && (p1 + p2 != 6);
    }

    private String getNormalScore() {
        String[] points = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        String score = points[p1];

        if (p1 == p2) {
            return score + "-All";
        }
        return score + "-" + points[p2];
    }

    private String getSpecialScore() {
        if (p1 == p2) {
            return "Deuce";
        }
        return getAdvantageOrWin();
    }

    private String getAdvantageOrWin() {
        String player = p1 > p2 ? p1N : p2N;
        if (isAdvantageScore()) {
            return "Advantage " + player;
        }
        return "Win for " + player;
    }

    private boolean isAdvantageScore() {
        return squareOfDifference() == 1;
    }

    private int squareOfDifference() {
        int diff = p1 - p2;
        return diff * diff;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.p1N)) {
            this.p1 += 1;
            return;
        }
        this.p2 += 1;
    }
}
