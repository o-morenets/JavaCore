package _20_multithreading._15_callable;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Transfer implements Callable<Boolean> {

    private static final long TRANSFER_TIMEOUT = 1;

    private final int id;
    private final Account accountFrom;
    private final Account accountTo;
    private final BigDecimal amount;

    public Transfer(int id, Account accountFrom, Account accountTo, BigDecimal amount) {
        this.id = id;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws InterruptedException {
        System.out.printf("#%d - Trying to lock account...%n", id);
        if (accountFrom.getLock().tryLock(TRANSFER_TIMEOUT, TimeUnit.SECONDS)) {
            try {
                if (accountTo.getLock().tryLock(TRANSFER_TIMEOUT, TimeUnit.SECONDS)) {
                    try {
                        System.out.printf("#%d started... %s -> %.2f -> %s%n", id, accountFrom, amount.doubleValue(), accountTo);
                        transfer(accountFrom, accountTo);
                        System.out.printf("#%d completed: %s [( %.2f )] %s%n", id, accountFrom, amount.doubleValue(), accountTo);
                        return true;
                    } finally {
                        accountTo.getLock().unlock();
                    }
                } else {
                    System.out.printf("#%d - TIMEOUT INNER LOCK%n", id);
                    return false;
                }
            } finally {
                accountFrom.getLock().unlock();
            }
        } else {
            System.out.printf("#%d - TIMEOUT OUTER LOCK%n", id);
            return false;
        }
    }

    private void transfer(Account accountFrom, Account accountTo) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(3000));
        try {
            accountFrom.withdraw(amount);
            accountTo.deposit(amount);
        } catch (Exception e) {
            System.out.printf("#%d - Account %s - NOT ENOUGH MONEY (%.2f)%n", id, accountFrom, amount.doubleValue());
            throw new RuntimeException(e);
        }
    }

    private static class Account {
        private final String name;
        private volatile BigDecimal balance;
        private final Lock lock;

        private Account(String name, BigDecimal initialBalance) {
            this.name = name;
            this.balance = initialBalance;
            this.lock = new ReentrantLock();
        }

        public Lock getLock() {
            return lock;
        }

        public void withdraw(BigDecimal amount) throws Exception {
            if (amount.compareTo(balance) > 0) {
                throw new Exception();
            }
            balance = balance.subtract(amount);
        }

        public void deposit(BigDecimal amount) {
            balance = balance.add(amount);
        }

        @Override
        public String toString() {
            return String.format("(%s : %.2f)", name, balance);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account("Alice", BigDecimal.valueOf(3000.0));
        Account acc2 = new Account("Bob", BigDecimal.valueOf(2000.0));

        List<Future<Boolean>> results = new LinkedList<>();
        try (ExecutorService ex = Executors.newFixedThreadPool(3)) {
            for (int i = 0; i < 100; i++) {
                Future<Boolean> future = ex.submit(new Transfer(i, acc1, acc2, BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(400))));
                results.add(future);
            }
            ex.shutdown();
            ex.awaitTermination(0, TimeUnit.SECONDS);
        }
        results.stream()
                .filter(f -> f.state() == Future.State.FAILED)
                .forEach(System.out::println);

        System.out.println("Sum of balances = " + acc1.balance.add(acc2.balance));
    }
}
