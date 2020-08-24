package org.anefdef;


import java.util.List;

public class RegularManager extends CreditManager{

    int rangeFrom;
    int rangeTo;

    public RegularManager(String name, List<Score> scores, int rangeFrom, int rangeTo, int creditsNumber) {
        super(name, scores, creditsNumber);
        this.rangeTo = rangeTo;
        this.rangeFrom = rangeFrom;
    }

    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < creditsNumber; i++) {
            try {
                Thread.sleep(super.random.nextInt(rangeTo-rangeFrom)+rangeFrom);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long finish = System.currentTimeMillis();
        synchronized (scores) {
            super.scores.add(new Score(this.name,(int)(finish-begin)));
        }
    }
}
