package org.anefdef.task.censor;

import java.util.*;
import java.util.stream.Collectors;

public class Censor {
    private final Set<String> explicit;

    public Censor(Set<String> explicit) {
        this.explicit = explicit;
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
                .map(word -> word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase())
                .filter(explicit::contains)
                .distinct()
                .collect(Collectors.toList());
    }
}
