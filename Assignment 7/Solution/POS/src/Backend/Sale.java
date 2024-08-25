
package Backend;

import java.util.ArrayList;

/**
 *
 * @author Junaid
 */

public class Sale {
    private ArrayList<Product> cart;
    private ArrayList<Integer> quantityList;
    private String purchaseDate;
    private double totalBill;
    
    
    
//  ----------------------- C A R T
    
    public void addToCart(Product product, int quantity){
        cart.add(product);
        quantityList.add(quantity);
    }
    
    
//  ----------------------- P U R C H A S E
    
    public double generateTotalBill(Customer customer){
        double totalAmount = 0;
        
        int index = 0;
        for (Product p : cart){
            totalAmount += p.getRetailPrice() * quantityList.get(index);
            index++;
        }
        
        return totalAmount;
    }
}
