package anefdef;

import java.util.LinkedList;
import java.util.List;

public class MultiFinder {

    public boolean isMultiplied(List<Integer> input, int n) {
        var deque = new LinkedList<>(input);
                while (deque.size()>1) {
                    var result = deque.getFirst() * deque.getLast();
                    if (result == n) {
                        return true;
                    }
                    if (result < n) {
                        deque.removeFirst();
                    }
                    else {
                        deque.removeLast();
                    }
                }
        return false;
    }
}
