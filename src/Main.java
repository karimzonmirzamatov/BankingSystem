import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bank IpakYoliBank = new Bank();
        User karim = IpakYoliBank.createUser("Karim", 5, "test@gmail.com");
        Account account1 = IpakYoliBank.createAccount(karim, 5, Currency.EUR, 500);
        User Billi = IpakYoliBank.createUser("Bilol", 1, "bilil@gmail.com");
        Account account2 = IpakYoliBank.createAccount(Billi, 1, Currency.EUR, 400);
        IpakYoliBank.transfer(1, 5, 45);
        System.out.println(IpakYoliBank.getTransactions());
        ArrayList<Bank> myBank = new ArrayList<>();

    }
}
