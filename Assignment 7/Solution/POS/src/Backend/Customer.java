
package Backend;

/**
 *
 * @author Junaid
 */

public class Customer {
   
    
    private String name, address;
    private String type;
    private int discount;
    
//  ----------------------- S E T T E R S
    
    public void setName(String name){
        if (!name.isBlank()){
            this.name = name;
        }
    }
    
    public void setAddress (String address){
        if (!address.isBlank()){
            this.address = address;
        }
    }
    
    public void setCustomerType(String customerType){
        if (customerType.equalsIgnoreCase("REGULAR") || customerType.equalsIgnoreCase("PREMIUM") ||
            customerType.equalsIgnoreCase("SIMPLE")){
            this.type = customerType;
        }
    }
    
    
    public void setDiscount (){
        String customerType = type.toUpperCase();
        
        switch (customerType){
            case "REGULAR" -> {   
                this.discount = 20;
            }
            
            case "PREMIUM" -> {
                this.discount = 50;
            }
            
            default -> {
                this.discount = 0;
            }
        }
    }
    
    public void setDiscount (int discount){
        if (discount >= 0){
            this.discount = discount;
        }
    }
    
//  ----------------------- G E T T E R S

    public String getName(){
        return name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getCustomerType(){
        return type;
    }
    
    public int getDiscount(){
        return discount;
    }
    
//  ----------------------- C O N S T R U C T O R
    
    public Customer (String name, String address, String customerType){
        setName(name);
        setAddress(address);
        setCustomerType(customerType);
        setDiscount();
    }
}

    