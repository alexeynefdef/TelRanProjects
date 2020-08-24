package org.anefdef;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int CREDITS_NUMBER = 20;

    public static void main(String[] args) throws InterruptedException {
        List<Result> results = new ArrayList<>();

        Thread masha = new LoanIssuer(100,200,"Masha",results,CREDITS_NUMBER);
        Thread petya = new LoanIssuer(200,300,"Petya",results,CREDITS_NUMBER);
        Thread vasya = new InspiredLoanIssuer(200,300,"Vasya",results,CREDITS_NUMBER,50,100,20);

        masha.start();
        petya.start();
        vasya.start();

        masha.join();
        petya.join();
        vasya.join();

        System.out.println(results);
    }
}
