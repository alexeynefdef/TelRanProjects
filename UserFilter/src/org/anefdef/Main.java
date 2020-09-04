package org.anefdef;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Account a1 = new Account("12341234",110000,false);
        Account a2 = new Account("12344321",0,false);
        Account a3 = new Account("12343258",80750,false);
        Account a4 = new Account("09876543",0,true);
        List<Account> accounts = new ArrayList<>();
        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a3);
        accounts.add(a4);

        Predicate<Account> onBalance = account -> account.getBalance() > 0;
        Predicate<Account> largeBalance = account -> account.getBalance() > 100_000;
        Predicate<Account> blocked = account -> account.isLocked;

        AccFilter aF = new AccFilter();

        aF.filter(accounts,onBalance);
        aF.filter(accounts,blocked.negate().and(largeBalance));

    }
}
