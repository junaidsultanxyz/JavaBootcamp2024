
package Backend;

import java.util.ArrayList;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

/**
 *
 * @author Junaid
 */

public class Sale {
    private Customer customer;
    private ArrayList<Product> cart;
    private String purchaseDate;
    private double totalBill;
    
    
    //  ----------------------- C A R T
    
    public void addToCart(Product product, int quantity){
        product.setQuantitySelected(quantity);
        cart.add(product);
    }
    
    
    //  ----------------------- P U R C H A S E
    
    public void addToCart(Product p){
        cart.add(p);
    }
    
    public double calculateUndiscountedBill(){
        double totalAmount = 0;
        
        for (Product p : cart){
            totalAmount += p.getRetailPrice() * p.getQuantitySelected();
        }
        
        return totalAmount;
    }
    
    public double calculateDiscount(double totalAmount , Customer customer){
        double discount = (customer.getDiscount()/100) * totalAmount;
        
        return discount;
    }
    
    public double generateDiscountedBill(Customer customer){
        return calculateUndiscountedBill() - calculateDiscount(calculateUndiscountedBill(), customer);
    }
    
    
    public double getCost(ArrayList<Product> cart){
        double cost = 0;
        
        for (Product p : cart){
            cost += p.getWholesalePrice();
        } 
        
        return cost;
    }
    
    public double calculateProfit(ArrayList<Product> cart, Customer customer){
        double profit = 0;
        
        double cost = getCost(cart);
        double price = generateDiscountedBill(customer);
        profit = price - cost;
        
        return profit;
    }
    
    
    // ----------------------- S E T T E R
    
    public void purchase(ArrayList<Product> cart, Customer customer){
        this.totalBill = generateDiscountedBill(customer);
        
        for (Product p : cart){
            Product newP = Database.findProductByName(p.getName());
            newP.setQuantity(newP.getStock() - p.getQuantitySelected());
            newP.setTotalSold(p.getQuantitySelected());
            
            Database.updateProduct(p.getName(), newP);
        }
    }
    
    public void setCustomer(Customer c){
        this.customer = c;
    }
    
    // ----------------------- G E T T E R
    
    public ArrayList<Product> getCart(){
        return cart;
    }
        
    public String getPurchaseDate(){
        return purchaseDate;
    }
    
    public double getTotalBill(){
        return totalBill;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    
    // ----------------------- C O N S T R U C T O R
    
    public Sale(){
        this.cart = new ArrayList<>();
        this.purchaseDate = "" + java.time.LocalDate.now();
        
    }
    
    
    public Sale(ArrayList<Product> cart, Customer c, String date){
        this.cart = new ArrayList<>();
        this.customer = c;
        this.purchaseDate = date;
    }
}
