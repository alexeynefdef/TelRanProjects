package org.anefdef;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class AccFilterTest {

    AccFilter filter;

    @BeforeEach
    void init() {
        filter = new AccFilter();
    }

    @Test
    public void testFilter() {

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

        List<Account> expected = new ArrayList<>();
        expected.add(a1);
        expected.add(a3);
        assertEquals(expected,filter.filter(accounts,onBalance));
    }
}