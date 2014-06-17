//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/23/14			Project 17.7
//
//	CSC*E224				Programming Assignment VII		Problem 2
//****************************************************************************************

package edu.housatonic.www.assignment7.problem2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeObj {
	
	private ObjectInputStream input;
	
	// Open File Method
	public void openFile(String fileName){
		try{
			input = new ObjectInputStream(new FileInputStream(fileName));
		}
		catch(IOException e){
			System.err.println("Error opening file.");
		}
	}
	
	// Write to file method
	public void readRecords(){
		openFile("records.ser");
		
		AccountRecord record;
		System.out.printf("%-10s%-12s%-12s%10s\n", "Account", "First Name", "Last Name", "Balance");
		
			try{
				while(true){
					record = (AccountRecord) input.readObject();
					
					// Display record
					System.out.printf("%-10d%-12s%-12s%10.2f\n", record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance());
				}
			}
			catch(EOFException e){
				return;
			}
			catch(ClassNotFoundException e){
				System.err.println("Unable to create object.");
			}
			catch(IOException e){
				System.err.println("Error during read from file.");
			}
		
		closeFile();
	}
	
	// Close file method
	public void closeFile(){
		if(input != null)
			try {
				input.close();
			} catch (IOException e) {
				System.err.println("Error closing file.");
				System.exit(1);
			}
	}

}
