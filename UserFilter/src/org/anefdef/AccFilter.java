package org.anefdef;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AccFilter {

    public List<Account> filter(List<Account> accounts, Predicate<Account> p) {
        List<Account> out = new ArrayList<>();
        for (Account account:accounts) {
            if (p.test(account)) {
                out.add(account);
            }
        }
        return out;
    }

}
