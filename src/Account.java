import java.util.List;

public class Account {
    private User accountOwner;
    private int accountID;
    private Currency currency;
    private double balance;

    public Account(User accountOwner, int accountID, Currency currency, double balance) {
        this.accountOwner = accountOwner;
        this.accountID = accountID;
        this.currency = currency;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("You can not deposit negative or 0");
        } else if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new InsufficientBalanceException("Amount must be greater than 0");
        } else if (amount > balance) {
            throw new IllegalArgumentException("Not enough money on balance!");
        } else {
            this.balance -= amount;

        }

    }

    public double getBalance() {
        return balance;
    }

    public Currency getCurrency() {
        return currency;

    }

    public int getAccountID() {
        return accountID;
    }

    public String toString() {
        return "\nAccount ID>> " + accountID +
                "\nOwner>> " + accountOwner + " " +
                "\nBalance>> " + getBalance() +
                "\nCurrency: " + getCurrency();
    }

}


























