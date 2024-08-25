
package Backend;

/**
 *
 * @author Junaid
 */

public class Product {
    private String id, name, catagory;
    private double retailPrice, wholesalePrice;
    private int quantity;
    
//  ----------------------- S E T T E R S
    
    public void setID(String id){
        if (!id.isBlank()){
            this.id = id;
        }
    }
    
    public void setName(String name){
        if (!name.isBlank()){
            this.name = name;
        }
    }
    
    public void setCatagory (String catag){
        if (!catag.isBlank()){
            this.catagory = catag;
        }
    }
    
    public void setRetailPrice (double price){
        if (price > 0){
            this.retailPrice = price;
        }
    }
    
    public void setWholesalePrice (double price){
        if (price > 0){
            this.wholesalePrice = price;
        }
    }
    
    public void setQuantity (int quantity){
        if (quantity > 0){
            this.quantity = quantity;
        }
    }
    
    
//  ----------------------- G E T T E R S
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCatagory() {
        return catagory;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public int getQuantity() {
        return quantity;
    }
    
    
//  ----------------------- C O N S T R U C T O R
    
    public Product (String name, String catagory, double retailPrice, double wholesalePrice, int quantity){
        setName(name);
        setCatagory(catagory);
        setWholesalePrice(wholesalePrice);
        setRetailPrice(retailPrice);
        setQuantity(quantity);
    }
}
