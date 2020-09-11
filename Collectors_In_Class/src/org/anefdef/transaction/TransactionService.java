package org.anefdef.transaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionService {
    public Map<String,Long> getSumOfTransactionsForEachAccountByID(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.
                        groupingBy(Transaction::getAccountID,
                                Collectors.summingLong(Transaction::getSum)));
    }
}
