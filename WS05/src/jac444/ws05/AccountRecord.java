/*
 * Modified to include method combine, which takes a TransactionRecord object and combines the balance 
 * of the AccountRecord object and the amount value of the TransactionRecord object.
 */

package jac444.ws05;

import java.io.Serializable;

public class AccountRecord implements Serializable {
	private int account;
	private String fName;
	private String lName;
	private double balance;
	private TransactionRecord transaction;

	public AccountRecord() {
		this(0, "", "", 0.0);
		transaction = new TransactionRecord();
	}
	public AccountRecord(int a, String f, String l, double b) {
		setAccount(a);
		setfName(f);
		setlName(l);
		setBalance(b);
	}

	public void combine() {
		if (this.account == transaction.getAccountNo()) {
			setBalance(this.balance + transaction.getAmount());
		}
	}

	public void setAccount(int a)
	{
		account = a;
	}
	public void setfName(String name)
	{
		fName = name;
	}
	public void setlName(String name)
	{
		lName = name;
	}
	public void setBalance(double bal)
	{
		balance = bal;
	}
	public double getBalance() {
		return balance;
	}
	public int getAccount() {
		return account;
	}
	public String getfName() {
		return fName;
	}
	public String getlName() {
		return lName;
	}
}