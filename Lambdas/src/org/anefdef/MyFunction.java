package org.anefdef;

import java.util.function.Function;

public class MyFunction implements Function<Double,Double> {

    @Override
    public Double apply(Double x) {
        return Math.sqrt(x);
    }
}
