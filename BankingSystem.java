package Main;

import java.util.ArrayList;
import java.util.List;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class Account {
    private int accountId;
    private String accountHolder;
    private double balance;

    public Account(int accountId, String accountHolder, double initialBalance) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " into Account " + accountId + ". New balance: $" + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds in Account " + accountId);
        }
        balance -= amount;
        System.out.println("Withdrawn $" + amount + " from Account " + accountId + ". New balance: $" + balance);
    }
}

class Bank {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void transfer(int fromAccountId, int toAccountId, double amount) {
        try {
            Account fromAccount = getAccountById(fromAccountId);
            Account toAccount = getAccountById(toAccountId);

            fromAccount.withdraw(amount);
            toAccount.deposit(amount);

            System.out.println("Transferred $" + amount + " from Account " + fromAccountId +
                    " to Account " + toAccountId);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    private Account getAccountById(int accountId) {
        return accounts.stream()
                .filter(account -> account.getAccountId() == accountId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Account not found with ID " + accountId));
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Account aliceAccount = new Account(1, "Alice", 1000.0);
        Account bobAccount = new Account(2, "Bob", 500.0);

        bank.addAccount(aliceAccount);
        bank.addAccount(bobAccount);

        // Perform transactions
        aliceAccount.deposit(200.0);

        try {
            aliceAccount.withdraw(300.0);
            bank.transfer(1, 2, 200.0);
            bank.transfer(2, 1, 1000.0);  // This will result in an InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
