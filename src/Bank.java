import java.util.ArrayList;
import java.util.*;

public class Bank {
    final private ArrayList<Account> accounts;
    final private ArrayList<User> users;
    final private ArrayList<Transaction> transactions;

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
        if (findAccount(accountID).isPresent()) {
            throw new IllegalArgumentException("Account with this id exists!");
        }
        Account account = new Account(accountOwner, accountID, currency, balance);
        accounts.add(account);
        return account;
    }

    public Optional<Account> findAccount(int accountID) {
        for (Account account : accounts) {
            if (account.getAccountID() == accountID) {
                return Optional.of(account);

            }
        }
        return Optional.empty();
    }

    public void deposit(int accountID, double amount) {
        Account account = findAccount(accountID).orElseThrow(() -> new IllegalArgumentException("An account with this id is not found"));
        account.deposit(amount);
        Transaction deposit = new Transaction(
                null,
                account,
                amount,
                account.getCurrency(),
                TransactionType.DEPOSIT
        );
        transactions.add(deposit);
    }

    public boolean withdraw(int accountID, double amount) throws InsufficientBalanceException {
       Account account = findAccount(accountID).orElseThrow(()->
               new IllegalArgumentException("Account not found"));


        account.withdraw(amount);
        Transaction withdraw = new Transaction(
                account,
                null,
                amount,
                account.getCurrency(),
                TransactionType.WITHDRAW
        );
        transactions.add(withdraw);
        return true;

    }

    public User findUser(int userID) {
        for (User user : users) {
            if (user.getUserID() == userID) {
                return user;
            }

        }
        return null;
    }

    public void transfer(int senderID, int receiverID, double amount) throws InsufficientBalanceException {
        Account sender = findAccount(senderID).orElseThrow(()->new IllegalArgumentException("Sender not found"));
        Account receiver = findAccount(receiverID).orElseThrow(()->new IllegalArgumentException("Receiver not found"));

        if (senderID == receiverID) {
            throw new IllegalArgumentException("Illegal argument !");
        }else if (sender.getCurrency() != receiver.getCurrency()){
            throw new NotAcceptableTypeOfCurrency("Currency of sender does not match with currency of receiver");
        }
        sender.withdraw(amount);
        receiver.deposit(amount);

        Transaction transaction = new Transaction(sender,
                receiver,
                amount,
                sender.getCurrency(),
                TransactionType.TRANSFER);

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

    public List<Account> getAccounts() {
        return List.copyOf(accounts);
    }

}


