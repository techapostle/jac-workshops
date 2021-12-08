/*
* contains transaction record details
* */

package jac444.ws05;

import java.io.Serializable;

public class TransactionRecord implements Serializable {
    private int accountNo;
    private double amount;

    public TransactionRecord() {
        this(0, 0.0);
    }
    public TransactionRecord(int account, double balance) {
        this.accountNo = account;
        this.amount = balance;
    }

    public int getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

}