package org.anefdef;

public class Score {

    String name;
    int score;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Score: " + score + "\n";
    }
}
