package new_tasks;

import java.util.ArrayDeque;
import java.util.Deque;

public class HobaSkoba {

    public boolean bracketsAreCorrect(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        if (input.length() % 2 != 0) return false;

        for (char next : input.toCharArray()) {
            if (isOpen(next)) {
                deque.add(next);
            } else if (match(deque.getLast(), next)) {
                deque.removeLast();
            } else {
                return false;
            }
        }
        return (deque.isEmpty());
    }

    private boolean match(char last, char next) {
        return (last + next) == ('{' + '}') ||
                (last + next) == ('(' + ')') ||
                (last + next) == ('[' + ']');
    }

    private boolean isOpen(char c) {
        return c == '{' || c == '[' || c == '(';
    }
}
