package org.anefdef;

import java.util.*;
import java.util.function.Function;


public class Main {

    public static void main(String[] args) {

        //TODO: Rewrite following Lambda like (MyFunction impl...Function...)
        MyFunction myFunction = new MyFunction();
        var sqrt = myFunction.apply(2.2);

        //TODO: Write Lambda, witch provide List<String> and returns Set<String> (can use Function)
        Function<List<String>, Set<String>> def1 = new
                Function<List<String>, Set<String>>() {
                    @Override
                    public Set<String> apply(List<String> strings) {
                        return new HashSet<String>(strings);
                    }
                };
        //or like this
        Function<List<String>, Set<String>> def2 = strings -> new HashSet<String>(strings);
        //or even like that
        Function<List<String>, Set<String>> def3 = HashSet::new;

        List<String> input = new ArrayList<>(Arrays.asList("hello","hello","good bye","how are you","hello","good bye"));
        Set<String> out = def3.apply(input);

        //TODO: Using closures write ax²+bx+c (x - argument)
        Formula formula = new Formula(2.2,3.14,6.7);
        var res = formula.compute(5.1);

    }
}
















