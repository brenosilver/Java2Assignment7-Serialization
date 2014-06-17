//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/23/14			Project 17.7
//
//	CSC*E224				Programming Assignment VII		Problem 2
//****************************************************************************************

package edu.housatonic.www.assignment7.problem2;

public class TransactionRecord {
	private int accNumber;
	private double transAmmount;
	
	public TransactionRecord() {
		this(0, 0.0);
	}
	
	// Constructor
	public TransactionRecord(int accNumber, double transAmmount) {
		this.accNumber = accNumber;
		this.transAmmount = transAmmount;
	}


	// Mutable methods
	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public double getTransAmmount() {
		return transAmmount;
	}

	public void setTransAmmount(double transAmmount) {
		this.transAmmount = transAmmount;
	}
	

}
