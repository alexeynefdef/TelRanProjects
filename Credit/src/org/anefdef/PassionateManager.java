package org.anefdef;


import java.util.List;

public class PassionateManager extends CreditManager{

    int rangeFrom;
    int rangeTo;
    int rangeFromP;
    int rangeToP;
    final int PROBABILITY = 20;

    public PassionateManager(String name, List<Score> scores,
                             int rangeFrom,
                             int rangeTo,
                             int creditsNumber,
                             int rangeFromP,
                             int rangeToP) {

        super(name, scores, creditsNumber);
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.rangeFromP = rangeFromP;
        this.rangeToP = rangeToP;
    }

    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        int creditsWithPassion = 0;

        for (int i = 0; i < creditsNumber; i++) {
            int currentCreditDuration;

            if (creditsWithPassion == 0 && random.nextInt(100) < PROBABILITY) {
                creditsWithPassion = 3;
            }
            if (creditsWithPassion > 0) {
                currentCreditDuration = random.nextInt((rangeToP - rangeFromP) + rangeFromP);
                creditsWithPassion --;
            } else {
                currentCreditDuration = random.nextInt((rangeTo - rangeFrom) + rangeFrom);
            }
            try {
                Thread.sleep(currentCreditDuration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long finish = System.currentTimeMillis();
        synchronized (scores) {
            scores.add(new Score(this.name,(int)(finish-begin)));
        }
    }
}















