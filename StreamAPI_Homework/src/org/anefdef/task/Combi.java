package org.anefdef.task;

import java.util.List;
import java.util.function.Predicate;

public class Combi {

    public <T> Predicate<T> combine(List<Predicate<T>> list) {
        return list.stream().reduce(Predicate::and).orElse( x -> true);
    }
}
