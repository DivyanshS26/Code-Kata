package com.cgi.tennis.step3;

class PlayerName {
    private final String name;
    public PlayerName(String name) { this.name = name; }
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof PlayerName) {
            return name.equals(((PlayerName)obj).name);
        }
        if (obj instanceof String) {
            return name.equals(obj);
        }
        return false;
    }
    public String name() { return name; }
}
