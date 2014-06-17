//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/23/14			Project 17.5
//
//	CSC*E224				Programming Assignment VII		Problem 1
//****************************************************************************************

package edu.housatonic.www.assignment7.problem1;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.List;

public class WriteRecords {
	private Formatter output;
	
	public void openFile(String fileName){
		try {
			output = new Formatter(fileName);
		
		} catch (SecurityException e) {
			System.err.println("You do not have write access to this file.");
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.err.println("Error opening or creating file.");
			System.exit(1);
		}
		
	}
	
	
	public void addRecord(List<AccountRecord> accRecord){
		
		openFile("newmast.txt");
		
		for (AccountRecord record : accRecord) {
			
			output.format("%d\t %s %s\t %.2f\n", record.getAccount(),
					record.getFirstName(), record.getLastName(), 
					record.getBalance());	
			System.out.println("Account: " + record.getAccount() + " added to newmast.txt");
		}

		if(output != null)
			output.close();
		
	}
	
	// Log transactions that have no record on master
	public void LogTrans(List<TransactionRecord> trans){
		
		openFile("log.txt");
		
		for (TransactionRecord record : trans) {
			output.format("%d\t %.2f\n", record.getAccNumber(), record.getTransAmmount());
		}

		
		if(output != null)
			output.close();
		
	}

}
