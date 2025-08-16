package com.cgi.tennis.step3;

class Point {
    private final int value;
    public Point(int value) { this.value = value; }
    public boolean lessThan(int other) { return value < other; }
    public boolean greaterThan(Point other) { return value > other.value; }
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) return false;
        return value == ((Point)obj).value;
    }
    public int value() { return value; }
    public Point add(int by) { return new Point(value + by); }
}
