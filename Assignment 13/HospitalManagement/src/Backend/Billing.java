
package Backend;

import java.time.LocalDateTime;

/**
 *
 * @author Junaid
 */
public class Billing implements setup{
    private double amount;
    private int appointmentID;
    private String payer;
    private LocalDateTime datetime;
    
    @Override
    public Object[] getAllData() {
        return new Object[] {amount, appointmentID, payer, datetime} ;
    }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }
    
    
    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Billing(double amount, int appointmentID, String payer, LocalDateTime datetime) {
        this.amount = amount;
        this.appointmentID = appointmentID;
        this.payer = payer;
        this.datetime = datetime;
    }

    public Billing(double amount, int appointmentID, String payer) {
        this.amount = amount;
        this.appointmentID = appointmentID;
        this.payer = payer;
    }

    

    public Billing() {
    }

    @Override
    public String toString() {
        return "Billing{" + "amount=" + amount + ", appointment=" + appointmentID + ", payer=" + payer + ", datetime=" + datetime + '}';
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
