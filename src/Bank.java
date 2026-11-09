import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class Bank {
    private ArrayList<Account> accounts;
    private ArrayList<User> users;
    private ArrayList<Transaction> transactions;

    public Bank() {
        users = new ArrayList<>();
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public User createUser(String userName, int userId, String email) {
        User user = new User(userName, userId, email);
        users.add(user);
        return user;
    }

    public Account createAccount(User accountOwner, int accountID, Currency currency, double balance) {
        if (accountOwner == null) {
            throw new IllegalArgumentException("Account owner can not be empyt!");
        }
        if (findAccount(accountID) != null) {
            throw new IllegalArgumentException("Account with this id exists!");
        }
        Account account = new Account(accountOwner, accountID, currency, balance);
        accounts.add(account);
        return account;
    }

    public Account findAccount(int accountID) {
        for (Account a : accounts) {
            if (a.getAccountID() == accountID) {
                return a;

            }
        }
        return null;
    }

    public void deposit(int accountID, double amount) {
        Account account = findAccount(accountID);
        if (account == null) {
            throw new IllegalArgumentException("An account with this id is not found");
        }
        account.deposit(amount);
        Transaction deposit = new Transaction(
                null, account, amount, account.getCurrency(), TransactionType.DEPOSIT);
        transactions.add(deposit);
    }

    public void withdraw(int accountID, double amount) {
        Account account = findAccount(accountID);

        if (account == null) {
            throw new IllegalArgumentException("An account with this id is not found");

        }

        account.withdraw(amount);
        Transaction withdraw = new Transaction(
                account, null, amount, account.getCurrency(), TransactionType.WITHDRAW
        );
        transactions.add(withdraw);

    }

    public User findUser(int userID) {
        for (User user : users) {
            if (user.getUserID() == userID) {
                return user;
            }

        }
        return null;
    }

    public void transfer(int senderID, int receiverID, double amount) {
        Account sender = findAccount(senderID);
        Account receiver = findAccount(receiverID);
        if (sender == null) {
            throw new IllegalArgumentException("Account not found");
        }
        if (receiver == null) {
            throw new IllegalArgumentException("Account not found");
        }
        if (sender.getCurrency() != receiver.getCurrency()) {
            throw new IllegalArgumentException("Only same currency transfer");
        }
        if (senderID == receiverID) {
            throw new IllegalArgumentException("Illegal argument !");
        }
        sender.withdraw(amount);
        receiver.deposit(amount);

        Transaction transaction = new Transaction(sender, receiver, amount, sender.getCurrency(), TransactionType.TRANSFER);
        transactions.add(transaction);
    }

    public Transaction findTransaction(int transcationID) {
        for (Transaction trans : transactions) {
            if (trans.getTransactionId() == transcationID) {
                return trans;
            }
        }
        return null;
    }

    public ArrayList<Transaction> getTransactions() {
        return new ArrayList<>(transactions);

    }
    public ArrayList<Account> getAccounts(){
        return accounts;
    }

}


