
package Backend;

/**
 *
 * @author Junaid
 */

public class Analytics {
    public static int totalSales;
    public static double totalProfit;
    
    public static int totalRegularCustomer(){
        int regulars = 0;
        
        for (Customer c :Database.getCustomerList()){
            if (c.getCustomerType().equalsIgnoreCase("regular")){
                regulars++;
            }
        }
        
        return regulars;
    }
    
    
    public static String mostSellingProduct(){
        String name = "";
        
        for (Product p : Database.getProductList()){
            for (Product pq : Database.getProductList()){
                if (p.getTotalSold() > pq.getTotalSold()){
                    name = p.getName();
                }
            }
        }
        
        return name;
    }
}
