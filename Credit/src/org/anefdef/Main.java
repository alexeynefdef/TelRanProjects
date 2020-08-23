package org.anefdef;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Score> scores = new ArrayList<>();

        CreditManager manager1 = new RegularManager("Masha",scores,100,200,10);
        Thread masha = new Thread(manager1);

        CreditManager manager2 = new RegularManager("Petya",scores,200,300,10);
        Thread petya = new Thread(manager2);

        CreditManager manager3 = new PassionateManager("Vasya",scores,200,300,10,50,100);
        Thread vasya = new Thread(manager3);

        masha.start();
        petya.start();
        vasya.start();

        masha.join();
        petya.join();
        vasya.join();

        System.out.println(scores);
    }
}
