package org.anefdef.task.accounts;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.LongStream;

public class TransactionService {

    private final Predicate<Transaction> cancelled = transaction -> transaction.getState() == TransactionState.CANCELLED;
    private final Predicate<Transaction> finished = transaction -> transaction.getState() == TransactionState.FINISHED;
    private final Predicate<Transaction> processing = transaction -> transaction.getState() == TransactionState.PROCESSING;
    /**
     * Method, witch determines a sum of cancelled transactions of accounts with balance > 0
     * @param accounts List of accounts
     * @return long sum
     */
    public long getSumOfCancelledTransactions(List<AccountNew> accounts) {
        return accounts.stream()
                .filter(accountNew -> accountNew.getBalance() > 0)
                .flatMap(accountNew -> accountNew.getTransactions().stream())
                .filter(cancelled)
                .flatMapToLong(transaction -> LongStream.of(transaction.getSum()))
                .sum();
    }
}
