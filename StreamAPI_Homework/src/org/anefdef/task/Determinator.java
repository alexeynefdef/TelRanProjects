package org.anefdef.task;

import java.util.List;
import java.util.function.Predicate;

public class Determinator {

    public boolean isSimple(int n) {

        Predicate<Integer> if1 = x -> x > 0;
        Predicate<Integer> if2 = x -> x % 1 == 0;
        Predicate<Integer> if3 = x -> x % x == 0;

        Predicate<Integer> fin = List.of(if1,if2,if3).stream().reduce(Predicate::and).get();

        return fin.test(n);
    }
}

