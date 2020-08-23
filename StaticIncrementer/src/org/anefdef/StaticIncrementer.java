package org.anefdef;

public class StaticIncrementer {

    private static int counter = 0;

    public static void incrementer() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
