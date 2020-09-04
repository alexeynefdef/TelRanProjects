package org.anefdef;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        TernaryIntPredicate intPredicate = (a,b,c) -> a != b && b != c && a != c;

        System.out.println(intPredicate.test(1,2,3));
        System.out.println(intPredicate.test(2,2,3));
        System.out.println(intPredicate.test(2,3,2));

        Function<Integer,Integer> f = x -> x * 2;
        Function<Integer,Integer> g = x -> x + 3;

        Function<Integer,Integer> b = f.compose(g);

        System.out.println(b.apply(3));
    }
}
