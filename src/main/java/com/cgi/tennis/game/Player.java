package com.cgi.tennis.game;

public class Player {
    private final PlayerName name;
    private Point point;

    public Player(String playerName) {
        this.name = new PlayerName(playerName);
        this.point = new Point(0);
    }

    public void scorePoint() {
        this.point = this.point.add(1);
    }

    public PlayerName getName() {
        return name;
    }

    public Point getPoint() {
        return point;
    }
}

