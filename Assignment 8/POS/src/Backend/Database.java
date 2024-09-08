
package Backend;

import java.util.ArrayList;


/**
 *
 * @author Junaid Sultan
 */

public class Database {
    private static ArrayList<Product> productList = new ArrayList<>();
    private static ArrayList<Customer> customerList = new ArrayList<>();
    private static ArrayList<Account> accountList = new ArrayList<>();
    private static ArrayList<Sale> transactionList = new ArrayList<>();
    
//  ----------------------- A D D    &    R E M O V E    &    U P D A T E
    
    
    public static void addProduct(Product product){
        productList.add(product);
    }
    
    public static void addCustomer (Customer customer){
        customerList.add(customer);
    }
    
    public static void removeProduct (String productName, String id){
        for (Product p: productList){
            if (p.getName().equalsIgnoreCase(productName) && p.getId().equalsIgnoreCase(id)){
                productList.remove(p);
                
                Errors.showMessage("Product Removed !");
                break;
            }
        }
    }
    
    public static void removeCustomer (String name){
        for (Customer c: customerList){
            if (c.getName().equalsIgnoreCase(name)){
                customerList.remove(c);
                
                Errors.showMessage("Customer Removed !");
                break;
            }
        }
    }
    
    public static void updateProduct (String productName, Product newInfo){
        for (Product p: productList){
            
            if (p.getName().equalsIgnoreCase(productName)){
                p.setCatagory(newInfo.getCatagory());
                p.setRetailPrice(newInfo.getRetailPrice());
                p.setWholesalePrice(newInfo.getWholesalePrice());
                p.setQuantity(newInfo.getStock());
                

                break;
            }
        }
    }
    
    public static void updateCustomer (String customerName, Customer newInfo){
        for (Customer c : customerList){
            if (c.getName().equalsIgnoreCase(customerName)){
                c.setAddress(newInfo.getAddress());
                c.setCustomerType(newInfo.getCustomerType());
                c.setDiscount(newInfo.getDiscount());

                break;
                
            }
        }
    }
    
//  ----------------------- G E T T E R
    
    public static ArrayList<Product> getProductList(){
        return productList;
    }
    
    public static ArrayList<Customer> getCustomerList(){
        return customerList;
    }
    
    public static ArrayList<Sale> getTransactionHistory(){
        return transactionList;
    }
    
//  ----------------------- L O G I N  /  S I G N U P
    
    
    public static void signUp(Account account){
        if (Account.isValidEmail(account.getEmail()) && (account.getPassword().length() > 5)){
            boolean check = true;
            
            for (Account acc: accountList){
                if (acc.getEmail().equalsIgnoreCase(account.getEmail())){
                    check = false;
                    break;
                }
            }
            
            if (check){
                accountList.add(account);
            }
            else{
                Errors.showMessage("Account already exist !");
            }
        }
        else{
            Errors.showMessage("Invalid input");
        }
    }
    
    public static Account login(Account account){
        if (Account.isValidEmail(account.getEmail())){
            for (Account acc: accountList){
                if (acc.getEmail().equalsIgnoreCase(account.getEmail())){
                    return acc;
                }
            }
        }
        
        return null;
    }
    
//  ----------------------- P R O D U C T S
    
    public static Product findProductByName(String name){
        
        for (Product p : productList){
            if (p.getName().equalsIgnoreCase(name)){
                return p;
            }
        }
        
        Errors.showMessage("product not found");
        return null;
    }
    
    public static ArrayList<Product> findProductByCatagory(String catagory){
        ArrayList<Product> products = new ArrayList<>();
        
        for (Product p : productList){
            if (p.getCatagory().equalsIgnoreCase(catagory)){
                products.add(p);
            }
        }
        
        return products;
    }
    
    
//  ----------------------- C U S T O M E R S
    
    public static Customer findCustomerByName(String name){
        
        for (Customer c : customerList){
            if (c.getName().equalsIgnoreCase(name)){
                return c;
            }
        }
        
        return null;

    }
    
    
    public static void addSale(Sale s){
        if (s != null){
            transactionList.add(s);
        }
    }
    
    
    
    
    public static void TestProducts(){
        productList.add(new Product("Eggs", "Grocery", 10, 8, 100));
        productList.add(new Product("Milk", "Grocery", 20, 15, 150));
        productList.add(new Product("Bread", "Grocery", 15, 10, 200));
        productList.add(new Product("Rice", "Grocery", 50, 40, 300));
        productList.add(new Product("Butter", "Grocery", 30, 25, 80));
        productList.add(new Product("Cheese", "Grocery", 40, 35, 90));
        productList.add(new Product("Chicken", "Meat", 100, 85, 60));
        productList.add(new Product("Beef", "Meat", 150, 130, 40));
        productList.add(new Product("Apple", "Fruit", 12, 10, 120));
        productList.add(new Product("Orange", "Fruit", 15, 12, 140));
        productList.add(new Product("Potato", "Vegetable", 8, 6, 200));
        productList.add(new Product("Tomato", "Vegetable", 10, 7, 180));
        productList.add(new Product("Carrot", "Vegetable", 9, 7, 160));
        productList.add(new Product("Fish", "Seafood", 120, 100, 50));
        productList.add(new Product("Shrimp", "Seafood", 200, 180, 30));
        productList.add(new Product("Pasta", "Grocery", 25, 20, 110));
        productList.add(new Product("Salt", "Grocery", 5, 3, 500));
        productList.add(new Product("Sugar", "Grocery", 10, 8, 400));
        productList.add(new Product("Coffee", "Beverage", 50, 45, 70));
        productList.add(new Product("Tea", "Beverage", 30, 25, 90));
    }
    
    public static void TestCustomers(){
        customerList.add(new Customer("John Doe", "123 Main St", "Normal", 5));
        customerList.add(new Customer("Jane Smith", "456 Oak St", "Regular", 10));
        customerList.add(new Customer("Michael Johnson", "789 Pine St", "Premium", 20));
        customerList.add(new Customer("Emily Davis", "321 Maple St", "Normal", 5));
        customerList.add(new Customer("James Brown", "654 Elm St", "Regular", 10));
        customerList.add(new Customer("Sarah Wilson", "987 Cedar St", "Premium", 20));
        customerList.add(new Customer("William Taylor", "111 Birch St", "Normal", 5));
        customerList.add(new Customer("Linda Anderson", "222 Willow St", "Regular", 10));
        customerList.add(new Customer("Robert Thomas", "333 Spruce St", "Premium", 20));
        customerList.add(new Customer("Patricia Moore", "444 Chestnut St", "Normal", 5));
        customerList.add(new Customer("Charles White", "555 Ash St", "Regular", 10));
        customerList.add(new Customer("Barbara Harris", "666 Fir St", "Premium", 20));
        customerList.add(new Customer("Joseph Martin", "777 Redwood St", "Normal", 5));
        customerList.add(new Customer("Jennifer Thompson", "888 Cypress St", "Regular", 10));
        customerList.add(new Customer("David Garcia", "999 Walnut St", "Premium", 20));
        customerList.add(new Customer("Susan Martinez", "1010 Aspen St", "Normal", 5));
        customerList.add(new Customer("Thomas Robinson", "2020 Hemlock St", "Regular", 10));
        customerList.add(new Customer("Jessica Clark", "3030 Poplar St", "Premium", 20));
        customerList.add(new Customer("Daniel Lewis", "4040 Beech St", "Normal", 5));
        customerList.add(new Customer("Nancy Walker", "5050 Sycamore St", "Regular", 10));
    }
}
