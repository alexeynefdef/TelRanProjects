package org.anefdef;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<Score> scores = new ArrayList<>();

        Cockroach cockroach1 = new Cockroach(10,"Vasya",scores);
        Cockroach cockroach2 = new Cockroach(10,"Petya",scores);
        Cockroach cockroach3 = new Cockroach(10,"Oleg",scores);
        Cockroach cockroach4 = new Cockroach(10,"Vanya",scores);
        Cockroach cockroach5 = new Cockroach(10,"Kirill",scores);
        Thread c1 = new Thread(cockroach1);
        Thread c2 = new Thread(cockroach2);
        Thread c3 = new Thread(cockroach3);
        Thread c4 = new Thread(cockroach4);
        Thread c5 = new Thread(cockroach5);
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c1.join();
        c2.join();
        c3.join();
        c4.join();
        c5.join();
        scores.sort(Score::compareTo);
        System.out.println(scores);

    }
}
