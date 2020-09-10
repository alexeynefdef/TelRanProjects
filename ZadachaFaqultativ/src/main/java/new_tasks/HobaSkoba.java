package new_tasks;

import java.util.ArrayDeque;
import java.util.Deque;

public class HobaSkoba {

    public boolean bracketsAreCorrect(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        if (input.length() % 2 != 0) return false;

        for (char next : input.toCharArray()) {

            if(deque.isEmpty() && (next == ')' || next == ']' || next == '}'))
                return false;

            if (next == '(' || next == '{' || next == '[') {
                deque.add(next);

            } else if ((next == ')' && deque.getLast() == '(') ||
                    (next == '}' && deque.getLast() == '{') ||
                    (next == ']' && deque.getLast() == '[')) {
                deque.removeLast();
            }
        }
        return (!deque.isEmpty());
    }
}
