package org.anefdef;

import java.util.List;
import java.util.Random;

public abstract class CreditManager implements Runnable{

    String name;
    int creditsNumber;
    Random random;
    final List<Score> scores;

    public CreditManager(String name, List<Score> scores, int creditsNumber) {
        this.name = name;
        this.random = new Random();
        this.scores = scores;
        this.creditsNumber = creditsNumber;
    }
}
