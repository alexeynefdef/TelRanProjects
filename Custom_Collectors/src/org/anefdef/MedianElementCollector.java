package org.anefdef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MedianElementCollector implements Collector<Integer, ArrayList<Integer>, Double> {

    @Override
    public Supplier<ArrayList<Integer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<ArrayList<Integer>, Integer> accumulator() {
        return ArrayList::add;
    }

    @Override
    public BinaryOperator<ArrayList<Integer>> combiner() {
        return (list, list2) -> {
            list.addAll(list2);
            return list;
        };
    }

    @Override
    public Function<ArrayList<Integer>, Double> finisher() {
        return list -> {
            list.sort(Integer::compareTo);

            if (list.size() % 2 == 0)
                return  ((double) list.get(list.size() / 2) + (double) list.get(list.size() / 2 - 1)) / 2;
            else
                return  (double) list.get(list.size() / 2);
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
