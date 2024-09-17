package Backend.Setup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private String email;
    private String password;
    private String accountType;

    private int minPassLength = 5;




    public void setEmail (String email){
        if (isValidEmail(email)){
            this.email = email;
        }
        else { Debug.showMessage("invalid email !"); }
    }


    public void setPassword (String pass){
        if (pass.length() >= minPassLength){
            this.password = pass;
        }
        else { Debug.showMessage("Enter valid password (must atleast be 5 char long)"); }
    }


    public void setAccountType (String accountType){
        
        if (accountType.equalsIgnoreCase("student")){
            this.accountType = accountType;
        }
        else if (accountType.equalsIgnoreCase("teacher")){
            this.accountType = accountType;
        }
        else if (accountType.equalsIgnoreCase("admin")){
            this.accountType = accountType;
        }
        else
        {
            Debug.showMessage("invalid account type");
        }
       
    }




    public String getEmail() { return email; }

    public String getPassword() { return password; }

    public String getAccountType() { return accountType; }


    
    public Account(){}

    public Account(String email, String password, String type){
        setEmail(email);
        setPassword(password);
        setAccountType(type);
    }

    public Account (String password){
        setPassword(password);
    }

    public Account(String email, String password){
        setEmail(email);
        setPassword(password);
    }




    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
