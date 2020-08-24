package org.anefdef;

import java.util.List;

public class InspiredLoanIssuer extends LoanIssuer {

    int inspiredMinTime;
    int inspiredMaxTime;
    /**
     * in percents
     */
    final int PROBABILITY;

    public InspiredLoanIssuer(int minIssueTime,
                              int maxIssueTime,
                              String name,
                              List<Result> results,
                              int numberCredits,
                              int inspiredMinTime,
                              int inspiredMaxTime,
                              int probability) {
        super(minIssueTime, maxIssueTime, name, results, numberCredits);
        this.inspiredMinTime = inspiredMinTime;
        this.inspiredMaxTime = inspiredMaxTime;
        this.PROBABILITY = probability;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        int inspirationValue = 0;
        for (int i = 0; i < numberCredits; i++) {

            if (inspirationValue == 0 && random.nextInt(100) < PROBABILITY) {
                inspirationValue = 3;
            }

            int timeToIssue;
            if (inspirationValue > 0) {
                inspirationValue--;
                timeToIssue = inspiredMinTime + random.nextInt(inspiredMaxTime - inspiredMinTime);

            } else {
                timeToIssue = minIssueTime + random.nextInt(maxIssueTime - minIssueTime);
            }

            try {
                Thread.sleep(timeToIssue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        results.add(new Result(name,(int) (endTime - startTime)));
    }
}
