package org.anefdef;

import java.util.List;
import java.util.Random;

public class Cockroach implements Runnable {

    private static final int FASTEST_STEP = 50;
    private static final int LONGEST_STEP = 100;

    final int stepsNumber;
    final String name;
    final List<Score> scores;
    Random random = new Random(FASTEST_STEP);

    public Cockroach(int stepsNumber, String name, List<Score> scores) {
        this.name = name;
        this.stepsNumber = stepsNumber;
        this.scores = scores;
    }

    @Override
    public void run() {
        int begin = (int)System.currentTimeMillis();
        for (int i = 0; i < stepsNumber; i++) {
            try {
                Thread.sleep(random.nextInt(LONGEST_STEP));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int res = (int)System.currentTimeMillis();

        synchronized (scores) {
            scores.add(new Score(name,res-begin));
        }
    }
}
