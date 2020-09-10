package org.anefdef.task.censor;

import java.util.*;
import java.util.stream.Collectors;

public class Censor {
    private final Set<String> explicit;

    public Censor(Set<String> explicit) {
        this.explicit = explicit.stream()
        .map(String::toLowerCase).collect(Collectors.toSet());
    }

    /**
     * Method that find explicit words from dictionary
     * and returns a List of them.
     *
     * @param text in UTF8 charset
     * @return List<String> of words or empty List if no match found
     */
    public List<String> parentalAdvisory(String text) {
        return Arrays.stream(text.split(" "))
                .map(String::toLowerCase)
                .filter(explicit::contains)
                .collect(Collectors.toList());
    }
}
