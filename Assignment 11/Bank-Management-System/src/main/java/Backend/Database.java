
package Backend;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Junaid Sultan
 */
public class Database {
    private static ArrayList<Account> accountList = new ArrayList<>();
    private static ArrayList<Transaction> transactionList = new ArrayList<>();
    
    public static ArrayList<Account> getAccountList(){
        return accountList;
    }
    
    public static boolean accExist (String id){
        for (Account acc : accountList){
            if (acc.getAccountId().equalsIgnoreCase(id)){
                return true;
            }
        }
        
        return false;
    }
    
    public static void addAccount(Account account){
        accountList.add(account);
    }
    
    public static void removeAccount (String id){
        for (Account a : accountList){
            if (a.getAccountId().equalsIgnoreCase(id)){
                accountList.remove(a);
                break;
            }
        }
    }
    
    public static void updateAccount (String id, Account updatedInfo){
        for (Account a : accountList){
            if (a.getAccountId().equalsIgnoreCase(id)){
                a.setName(updatedInfo.getName());
                a.setBalance(updatedInfo.getBalance());
                a.setType(updatedInfo.getType());
                a.setInterestRate(updatedInfo.getInterestRate());
                
                break;
            }
        }
    }
    
    public static Account getAccountByID(String id){
        for (Account a : accountList){
            if (a.getAccountId().equalsIgnoreCase(id)){
                return a;
            }
        }
        
        return null;
    }
    
    public static ArrayList<Account> searchAccount(String keyword){
        ArrayList<Account> accounts = new ArrayList<>();
        
        for (Account a : accountList){
            if (a.getName().contains(keyword) || a.getAccountId().contains(keyword) || a.getType().contains(keyword) || ("" + a.getInterestRate()).contains(keyword) || ("" + a.getBalance()).contains(keyword)){
                accounts.add(a);
            }
        }
        
        return accounts;
    }
    
    
    public static ArrayList<Transaction> searchTransit (String keyword){
        ArrayList<Transaction> transactions = new ArrayList<>();
        
        for (Transaction t : transactionList){
            if (t.getReceivingID().contains(keyword) || t.getSenderID().contains(keyword) || t.getTransitID().contains(keyword) || t.getDate().toString().contains(keyword)){
                transactions.add(t);
            }
        }
        return transactions;
    }
    
    public static String generateTransitID(String transactionType){
        return "T" + transactionList.size() + ".ID" + transactionType + LocalDate.now() + "-" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    }
    
    public static void addTransaction(Transaction t){
        transactionList.add(t);
    }
    
    public static ArrayList<Transaction> getTransitList(){
        return transactionList;
    }
    
    public static void LoadData(){
        transactionList = FileHandling.ReadDate("transactions.txt");
        accountList = FileHandling.ReadDate("accounts.txt");
        
        if (FileHandling.ReadDate("transactions.txt") != null || FileHandling.ReadDate("accounts.txt") != null){
            transactionList = FileHandling.ReadDate("transactions.txt");
            accountList = FileHandling.ReadDate("accounts.txt");
        }
    }
    
    public static void WriteData(){
        FileHandling.WriteData(accountList, "accounts.txt");
        FileHandling.WriteData(transactionList, "transactions.txt");
    }
    
    
    public static void TestAccountData(){
        accountList.add(new Account("John Doe", "ACC123", 1500.50, "save", 3.5f));
        accountList.add(new Account("Jane Smith", "ACC124", 2000.00, "save", 4.2f));
        accountList.add(new Account("Mark Johnson", "ACC125", 1200.75, "current", 0f));
        accountList.add(new Account("Emily Davis", "ACC126", 2500.00, "current", 0f));
        accountList.add(new Account("Sarah Wilson", "ACC127", 1800.30, "save", 2.8f));
        accountList.add(new Account("James Brown", "ACC128", 2700.60, "current", 0f));
        accountList.add(new Account("Robert Clark", "ACC129", 3200.10, "save", 3.7f));
        accountList.add(new Account("Laura Turner", "ACC130", 2200.50, "save", 4.1f));
        accountList.add(new Account("Kevin Lewis", "ACC131", 1000.40, "current", 0f));
        accountList.add(new Account("Emma Harris", "ACC132", 1300.25, "save", 2.5f));
        accountList.add(new Account("Olivia Moore", "ACC133", 2600.80, "current", 0f));
        accountList.add(new Account("Liam Scott", "ACC134", 2900.55, "save", 3.3f));
        accountList.add(new Account("Sophia Young", "ACC135", 1750.20, "save", 4.0f));
        accountList.add(new Account("Isabella Hall", "ACC136", 3100.00, "current", 0f));
        accountList.add(new Account("Mason Adams", "ACC137", 1500.00, "current", 0f));
        accountList.add(new Account("Mia Lee", "ACC138", 2850.40, "save", 3.9f));
        accountList.add(new Account("Jackson White", "ACC139", 1350.75, "save", 2.3f));
        accountList.add(new Account("Lily Thomas", "ACC140", 1650.60, "current", 0f));
        accountList.add(new Account("Elijah Harris", "ACC141", 2050.20, "save", 4.5f));
        accountList.add(new Account("Ava Robinson", "ACC142", 2400.50, "current", 0f));
    }
}
