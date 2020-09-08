package org.anefdef.test;

import org.anefdef.task.accounts.AccountNew;
import org.anefdef.task.accounts.Transaction;
import org.anefdef.task.accounts.TransactionService;
import org.anefdef.task.accounts.TransactionState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    TransactionService service;

    @BeforeEach
    void init() {
        service = new TransactionService();
    }

    @Test
    void testGetSumOfCancelledTransactions() {
        Transaction t1 = new Transaction("1001a1", TransactionState.PROCESSING,200);
        Transaction t2 = new Transaction("1002b4", TransactionState.CANCELLED,560);
        Transaction t3 = new Transaction("1006m7", TransactionState.CANCELLED,1500);
        Transaction t4 = new Transaction("1008h2", TransactionState.FINISHED,2000);
        Transaction t5 = new Transaction("1017l3", TransactionState.PROCESSING,790);

        AccountNew a1 = new AccountNew("a1a1",40_000, List.of(t1,t2));
        AccountNew a2 = new AccountNew("a2b1",60_000, List.of(t3,t4,t5));

        assertEquals(2060,service.getSumOfCancelledTransactions(List.of(a1,a2)));
    }

}