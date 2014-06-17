//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/23/14			Project 17.7
//
//	CSC*E224				Programming Assignment VII		Problem 2
//****************************************************************************************

package edu.housatonic.www.assignment7.problem2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileMatch {
	private List<AccountRecord> records;
	List<TransactionRecord> transactions;
	
	//Constructor
	public FileMatch() {
		records = new ArrayList<AccountRecord>();
		transactions = new ArrayList<TransactionRecord>();
	}
	
	//Read Old Master method
	public List<AccountRecord> ReadOldMast() throws IOException{
		
		Scanner in = null;
		
		try{
			in = new Scanner(new BufferedInputStream(new FileInputStream("oldmast.txt")));
		
				while(in.hasNext()){
					AccountRecord record = new AccountRecord();
					
					record.setAccount(in.nextInt());
					record.setFirstName(in.next());
					record.setLastName(in.next());
					record.setBalance(in.nextDouble());
					
					records.add(record);
				}
			System.out.println("oldmast.txt Scan completed...");
		}
		
		finally{
			if(in !=null)
				in.close();
		}
		
		return records;
		
	} // End of ReadOldMast
	
	
	//Read Transactions method
	public List<TransactionRecord> ReadTrans() throws IOException{
		
		Scanner in = null;
		
		try{
			in = new Scanner(new BufferedInputStream(new FileInputStream("trans.txt")));
		
				while(in.hasNext()){
					TransactionRecord trans = new TransactionRecord();
					
					trans.setAccNumber(in.nextInt());
					trans.setTransAmmount(in.nextDouble());
					
					transactions.add(trans);
				}
			System.out.println("trans.txt scan completed...");
		}
		
		finally{
			if(in !=null)
				in.close();
		}
		
		return transactions;
		
	} // End of ReadTrans
	
	// Compare Records method
	public void CompareRecords(List<AccountRecord> rcds, List<TransactionRecord> trs){
		
		boolean notInMaster = false; // keep track of transactions that aren't in masterRecord
		double newBalance;
		
		List<TransactionRecord>  logtransArr = new ArrayList<TransactionRecord>(); // Array with transactions that are not in master

		WriteRecords wrRecords = new WriteRecords();
		
		// Check every record for matches
		for (TransactionRecord transR : trs){
			notInMaster = true;
			for (AccountRecord acRcd : rcds){
				if(transR.getAccNumber() == acRcd.getAccount()){
					
					// Set new balance to master record
					newBalance = transR.getTransAmmount() + acRcd.getBalance();
					acRcd.setBalance(newBalance);
		
					notInMaster = false;
				}
			}
			
			// if transaction is not in Master add transaction to array
			if(notInMaster == true){
				logtransArr.add(transR);
				notInMaster = false;
			}
		}
		
		wrRecords.addRecord(rcds);
		wrRecords.LogTrans(logtransArr);
	} // Ends CompareRecords

	
	// Mutable methods
	public List<AccountRecord> getRecords() {
		return records;
	}

	public void setRecords(List<AccountRecord> records) {
		this.records = records;
	}

}
