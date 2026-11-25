public class Transaction {
    final private Account sender;
    final private Account receiver;
    final private double amount;
    final private Currency currency;
    private static int nextTransactionID = 1;
    private int transactionID;
    final private TransactionType type;


    public Transaction(Account sender, Account receiver, double amount, Currency currency, TransactionType type) {
        this.transactionID = nextTransactionID++;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.currency = currency;
        this.type = type;

    }

    public int getTransactionId() {

        return transactionID;
    }

    public Account getSender() {
        return sender;
    }

    public Account getReceiver() {
        return receiver;

    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public TransactionType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction { " +
                "\nTransaction ID: " + transactionID +
                "\nFROM Account ID: " + sender.getAccountID() +
                "\nTO Account ID: " + receiver.getAccountID() +
                "\nCurrency: " + getCurrency() +
                "\nAMOUNT: " + amount +
                "\nTRANSACTION TYPE: " + type +
                " }";

    }

}












