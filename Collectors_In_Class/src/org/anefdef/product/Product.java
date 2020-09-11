package org.anefdef.product;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.reducing;

public class Product {

    public int getProduct(List<Integer> numbers) {
        Stream<Integer> stream = numbers.stream();
        return stream.collect(reducing(1, (res, next) -> res * (next * next)));
    }
}
