
package Backend;

/**
 *
 * @author Junaid Sultan
 */

public class Employee {
    private Account account;
    private String id;
    
    
//  ----------------------- S E T T E R S
    
    public void setID(String id){
        if (!id.isBlank()){
            this.id = id;
        }
    }
    
//  ----------------------- G E T T E R S
    
    public String getID(){
        return id;
    }
    
//  ----------------------- C O N S T R U C T O R
    
    public Employee(String email, String pass){  
        this.account = new Account(email, pass);
    }
    
    public Employee(Account account){  
        this.account = account;
    }
    
    public Employee(String id){
        setID(id);
    }
}
