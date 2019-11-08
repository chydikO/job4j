package ru.job4j.io;

public class Player {
    private int matches;
    private String name;

    public Player(int matches, String name) {
        this.matches = matches;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }
}
