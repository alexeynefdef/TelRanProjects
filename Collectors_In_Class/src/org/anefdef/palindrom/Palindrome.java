package org.anefdef.palindrom;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Palindrome {
    public Map<Boolean, List<String>> separateWords(List<String> words) {
        return words.stream()
                .collect(Collectors.partitioningBy(this::isPalindrome));
    }

    public boolean isPalindrome(String text) {
        return new StringBuilder(text).reverse().toString().equals(text);
    }

}
