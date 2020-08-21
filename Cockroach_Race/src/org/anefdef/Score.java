package org.anefdef;

public class Score implements Comparable<Score>{
    private final String name;
    private final int result;

    public Score(String name, int duration) {
        this.name = name;
        this.result = duration;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", result: " + result + "\n";
    }

    @Override
    public int compareTo(Score score) {
        return this.result - score.result;
    }
}
