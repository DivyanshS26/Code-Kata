package com.cgi.tennis.game;

public enum PointName {
    LOVE(0, "Love"),
    FIFTEEN(1, "Fifteen"),
    THIRTY(2, "Thirty"),
    FORTY(3, "Forty");

    private final int value;
    private final String name;

    PointName(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static PointName fromValue(int value) {
        for (PointName p : values()) {
            if (p.value == value) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid point value: " + value);
    }
}
