package org.anefdef.test;

import org.anefdef.task.Account;
import org.anefdef.task.AccountsTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountsToolTest {

    AccountsTool tool;

    @BeforeEach
    void init() {
        tool = new AccountsTool();
    }

    @Test
    void testBlockTheOligarch_3el_3blocked(){
        Account a1 = new Account("1001",10_000);
        Account a2 = new Account("1002",50_000);
        Account a3 = new Account("1003",70_000);

        List<Account> toTest = List.of(a1,a2,a3);

        tool.blockTheOligarch(toTest,5000);
        for (Account account:toTest) {
            assertTrue(account.isBlocked());
        }
    }


    @Test
    void testGetSumOfBlocked_3el_3blocked(){
        Account a1 = new Account("1001",10_000);
        Account a2 = new Account("1002",50_000);
        Account a3 = new Account("1003",70_000);

        List<Account> toTest = List.of(a1,a2,a3);

        tool.blockTheOligarch(toTest,5000);
        assertEquals(130000,tool.getSumOfBlocked(toTest));
    }



    @Test
    void testBlockTheOligarch_3el_3unblocked(){
        Account a1 = new Account("1001",10_000);
        Account a2 = new Account("1002",50_000);
        Account a3 = new Account("1003",70_000);

        List<Account> toTest = List.of(a1,a2,a3);

        tool.blockTheOligarch(toTest,100_000);
        for (Account account:toTest) {
            assertFalse(account.isBlocked());
        }
    }


}