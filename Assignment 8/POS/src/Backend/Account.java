
package Backend;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Junaid Sultan
 */

public class Account {
    protected static enum TYPE{
        CUSTOMER,
        MANAGER,
        ADMIN
    }
    
    private String email, password;
    private TYPE accountType;
    private final int minPasswordLength = 5;
    
//  ----------------------- S E T T E R S
    
    public void setEmail(String email){
        if (isValidEmail(email)){
            this.email = email;
        }
    }
    
    public void setPassword(String password){
        if (password.length() > minPasswordLength && !password.isBlank()){
            this.password = password;
        }
    }
    
    public void setAccountType(TYPE type){
        this.accountType = type;
    }
    
    
//  ----------------------- G E T T E R S
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public TYPE getAccountType(){
        return accountType;
    }
    
    
//  ----------------------- C O N S T R U C T O R
    
    public Account(String email, String password){
        setEmail(email);
        setPassword(password);
        setAccountType(TYPE.MANAGER);
    }
    
    public Account(){}
    
//  ----------------------- O T H E E R
    
    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
