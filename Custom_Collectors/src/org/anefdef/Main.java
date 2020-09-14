package org.anefdef;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        double resEven = Stream.of(24,18,10,23)
                .collect(new MedianElementCollector());
        System.out.println(resEven);
        double resOdd = Stream.of(24,18,10,4,23)
                .collect(new MedianElementCollector());
        System.out.println(resOdd);

    }
}
