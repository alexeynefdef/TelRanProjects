import java.util.*;

public class StringSeparator {

    public List<String> doStuff(int k, String input) {
        List<String> out = new ArrayList<>();
        if (k < input.length()) {
            for (int i = 0; i <= input.length() - k; i++) {
                var substring = input.substring(i, i + k);
                if (isValid(substring)) {
                    out.add(substring);
                }
            }
            return out;
        }
        return null;
    }

    public boolean isValid(String string) {
        char[] spl = string.toCharArray();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < string.length(); i++) {
            set.add(spl[i]);
        }
        return set.size() == string.length() - 1;
    }

}
