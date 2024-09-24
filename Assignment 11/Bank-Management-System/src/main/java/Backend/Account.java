
package Backend;

import java.io.Serializable;

/**
 *
 * @author Junaid Sultan
 */
public class Account implements Serializable{
    private String name, accountId;
    private double balance;
    private String type;
    private float interestRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public Account(String name, String accountId, double balance) {
        this.name = name;
        this.accountId = accountId;
        this.balance = balance;
    }

    public Account(String type, float interestRate) {
        this.type = type;
        this.interestRate = interestRate;
    }

    public Account(String name, String accountId, double balance, String type, float interestRate) {
        this.name = name;
        this.accountId = accountId;
        this.balance = balance;
        this.type = type;
        this.interestRate = interestRate;
    } 
}
