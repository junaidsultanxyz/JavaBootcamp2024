package Backend;

import java.util.ArrayList;

/**
 *
 * @author Junaid
 */

public class POS {

    private static ArrayList<Product> productList = new ArrayList<>();
    private static ArrayList<Customer> customerList = new ArrayList<>();
    
    
//  ----------------------- A D D    &    R E M O V E 
    
    public void addProduct(Product product){
        productList.add(product);
    }
    
    public void addCustomer (Customer customer){
        customerList.add(customer);
    }
    
    public void removeProduct (String productName){
        for (Product p: productList){
            if (p.getName().equalsIgnoreCase(productName)){
                productList.remove(p);
                break;
            }
        }
    }
    
    public void removeCustomer (String name){
        for (Customer c: customerList){
            if (c.getName().equalsIgnoreCase(name)){
                customerList.remove(c);
                break;
            }
        }
    }
    
//  ----------------------- G E T T E R
    
    public ArrayList<Product> getProductList(){
        return productList;
    }
    
    public ArrayList<Customer> getCustomerList(){
        return customerList;
    }   
}
