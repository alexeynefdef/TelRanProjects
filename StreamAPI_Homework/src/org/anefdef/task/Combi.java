package org.anefdef.task;

import java.util.List;
import java.util.function.Predicate;

public class Combi {

    public Predicate<Integer> combine(List<Predicate<Integer>> list) {
        return list.stream().reduce(Predicate::and).orElse( x -> true);
    }
}
