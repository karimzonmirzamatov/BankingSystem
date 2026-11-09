import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

class AccountFileStorage {
    private final Path myPath= Path.of("data","dataBase.txt");
    public void saveInfo(List<Account> accounts)throws IOException {

        Files.createDirectories(myPath.getParent());
        try(BufferedWriter info = Files.newBufferedWriter(
                myPath, StandardOpenOption.CREATE)){
            for(Account a:accounts){
                String line = "Account ID: "+a.getAccountID()+"\nCurrency "+a.getCurrency()+"\nBalance "+a.getBalance();
                info.write(line);
                info.newLine();
            }
            info.newLine();
        }

    }
}