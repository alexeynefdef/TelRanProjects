import java.util.HashSet;
import java.util.Set;

public class Abductor {
    /**
     * Method that determines how many
     * different digits contains in given digit
     * @param n > 0
     * @return a List of integers
     */
    public Set<Integer> doStuff(int n) {
        Set<Integer> output = new HashSet<>();
        if (n == 1)
            output.add(1);
        int current = n;
        for (int i = 1; i < n; i++) {
            if (i+(i+1) > current) {
                output.add(current);
            } else {
                output.add(i);
                current-=i;
            }
        }
        return output;
    }
}
