//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/23/14			Project 17.7
//
//	CSC*E224				Programming Assignment VII		Problem 2
//****************************************************************************************

package edu.housatonic.www.assignment7.problem2;

import java.io.Serializable;

public class AccountRecord implements Serializable{
	private int account;
	private String firstName;
	private String lastName;
	private double balance;
	
	// Default Constructor calls other constructor with default values
	public AccountRecord() {
		this(0, "", "", 0.0);
	}
	
	// 4 argument constructor
	public AccountRecord(int acct, String first, String last, double bal){
		setAccount(acct);
		setFirstName(first);
		setLastName(last);
		setBalance(bal);
	}
	
	// Combine transaction with balance method
	public double Combine(TransactionRecord transRecord){
		double newBalance = transRecord.getTransAmmount() + getBalance();
		return newBalance;
	}

	// Mutable methods
	public void setAccount(int acct) {
		account = acct;
	}
	
	public int getAccount() {
		return account;
	}

	public void setFirstName(String first) {
		firstName = first;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String last) {
		lastName = last;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setBalance(double bal) {
		balance = bal;
	}

	public double getBalance() {
		return balance;
	}


}
