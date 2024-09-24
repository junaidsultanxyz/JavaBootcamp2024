
package Backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Junaid Sultan
 */
public class Transaction implements Serializable{
    private String transitID;
    private String senderID, receivingID;
    private double amount;
    private LocalDate date;
    private LocalTime time;

    public String getTransitID() {
        return transitID;
    }

    public void setTransitID(String transitID) {
        this.transitID = transitID;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getReceivingID() {
        return receivingID;
    }

    public void setReceivingID(String receivingID) {
        this.receivingID = receivingID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Transaction(String transitID, String senderID, String receivingID, double amount) {
        this.date = LocalDate.now();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        this.time = LocalTime.parse(LocalTime.now().format(dtf));
        
        this.transitID = transitID;
        this.senderID = senderID;
        this.receivingID = receivingID;
        this.amount = amount;
    }
}
