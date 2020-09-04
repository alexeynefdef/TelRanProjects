package org.anefdef;


//TODO: Write a lambda, witch returns true if all 3 arguments are different

@FunctionalInterface
public interface TernaryIntPredicate {
    boolean test(int a, int b, int c);
}
