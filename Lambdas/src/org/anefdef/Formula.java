package org.anefdef;

import java.util.function.Function;

public class Formula {
    double a;
    double b;
    double c;

    public Formula(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double compute(double x) {
        Function<Double,Double> def1 = new Function<>() {

            @Override
            public Double apply(Double x) {
                return Math.pow(a * x, 2) + (b * x) + c;
            }
        };

        //or like this
        Function<Double,Double> def2 = y -> Math.pow(a * x, 2) + (b * x) + c;

        return def1.apply(x);
    }
}
