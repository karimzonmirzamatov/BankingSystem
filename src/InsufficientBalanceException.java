public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }

}

class InvalidTransactionTypeException extends RuntimeException {
    public InvalidTransactionTypeException(String message) {
        super((message));
    }

}
class NotAcceptableTypeOfCurrency extends RuntimeException{
    public NotAcceptableTypeOfCurrency(String message){
        super(message);
    }
}
