package org.anefdef;


import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> words = List.of("param","pam","Jean","cloud","Van","Damn");
        String concatenated =  words.stream()
                 .filter(s -> s.length() < 4)
                 .map(String::toUpperCase)
                 .distinct()
                 .reduce("Result: ", String::concat);

        System.out.println(concatenated);
    }
}
