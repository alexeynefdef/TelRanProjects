package org.anefdef;

public class Result {

    private final String name;
    private final int workTime;

    public Result(String name, int workTime) {
        this.name = name;
        this.workTime = workTime;
    }

    public String getName() {
        return name;
    }

    public int getWorkTime() {
        return workTime;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Time: " + workTime + "\n";
    }
}
