package org.anefdef;

import org.junit.platform.commons.util.StringUtils;

import java.lang.reflect.Array;
import java.util.*;

public class Lovely {
    /**
     * Method witch determines that is an integer lovely or not.
     *
     * @param n positive integer number
     * @return true if number is lovely
     */
    public boolean isLovely(int n) {
        List<String> digits = new ArrayList<>(Arrays.asList(Integer.toString(n).split("")));
        Map<String,Integer> toCount = new HashMap<>();

        for (String dig:digits) {
            if (!toCount.containsKey(dig)) {
                toCount.put(dig,1);
            } else {
                toCount.put(dig,toCount.get(dig) + 1);
            }
        }
        for (Integer value:toCount.values()) {
            if (value > 2)
                return false;
        }
        return true;
    }
}
