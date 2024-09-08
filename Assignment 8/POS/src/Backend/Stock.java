package Backend;

/**
 *
 * @author Junaid Sultan
 */

public class Stock {
    
    private int quantity;
    private boolean status;
    
//  ----------------------- S E T T E R S
    
    public void setQuantity(int quantity){
        if (quantity > 0){
            this.quantity = quantity;
        }
    }
    
    public void setStatus(){
        if (quantity > 0){
            this.status = true;
        }
        else {
            this.status = false;
        }
    }
    
    public void setStatus(boolean status){
        this.status = status;
    }
    
//  ----------------------- G E T T E R S
    
    public int getQuantity() { return quantity; }
    public boolean getStatus() { return status; }
    
    
//  ----------------------- C O N S T R U C T O R
    
    public Stock (int quantity){
        setQuantity(quantity);
        setStatus();
    }
}
