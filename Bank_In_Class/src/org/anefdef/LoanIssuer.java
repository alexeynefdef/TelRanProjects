package org.anefdef;

import java.util.List;
import java.util.Random;

public class LoanIssuer extends Thread {

    int minIssueTime;
    int maxIssueTime;
    String name;
    List<Result> results;
    int numberCredits;

    public LoanIssuer(int minIssueTime,
                      int maxIssueTime,
                      String name,
                      List<Result> results,
                      int numberCredits) {
        this.minIssueTime = minIssueTime;
        this.maxIssueTime = maxIssueTime;
        this.name = name;
        this.results = results;
        this.numberCredits = numberCredits;
    }

    Random random = new Random();

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberCredits; i++) {
            int timeToIssue = minIssueTime + random.nextInt(maxIssueTime - minIssueTime);
            try {
                Thread.sleep(timeToIssue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        results.add(new Result(name,(int)(endTime-startTime)));
    }
}
