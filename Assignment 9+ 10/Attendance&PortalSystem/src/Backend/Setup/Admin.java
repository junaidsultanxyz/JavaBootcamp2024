package Backend.Setup;

public class Admin {
    private Account account;

    public Admin(String email, String password){
        this.account = new Account(email, password);
        this.account.setAccountType("Faculty");
    }
}
