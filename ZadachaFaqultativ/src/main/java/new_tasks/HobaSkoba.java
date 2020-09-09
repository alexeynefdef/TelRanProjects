package new_tasks;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class HobaSkoba {

    public boolean bracketsAreCorrect(String input) {
        char[] chars = input.toCharArray();
        ArrayDeque<Character> deque = new ArrayDeque<>();

        if (input.length() % 2 != 0) return false;

        char current = ' ';
        for (char next : chars) {
            if(match(current,next)) {
                deque.removeLast();
                try {
                    current = deque.getLast();
                } catch (NoSuchElementException e) {
                    current = ' ';
                }
            } else {
                deque.addLast(next);
                current = next;
            }
        }
        return (!deque.isEmpty());
    }

    public static boolean match(char cur, char next) {
        StringBuilder toCheck = new StringBuilder().append(cur).append(next);
        String round = "()";
        String quad = "[]";
        String curly = "{}";
        return toCheck.toString().equals(round) || toCheck.toString().equals(quad) || toCheck.toString().equals(curly);
    }

}
