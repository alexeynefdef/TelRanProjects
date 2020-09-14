package org.anefdef.task;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class UniqueUsersCollector implements Collector<LogEntry, Set<String>, Integer> {

    @Override
    public Supplier<Set<String>> supplier() {
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<String>, LogEntry> accumulator() {
        return (set, element) -> set.add(element.getUserName());
    }

    @Override
    public BinaryOperator<Set<String>> combiner() {
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<String>, Integer> finisher() {
        return Set::size;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}
