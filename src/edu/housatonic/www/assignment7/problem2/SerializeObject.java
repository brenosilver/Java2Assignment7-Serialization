//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/23/14			Project 17.7
//
//	CSC*E224				Programming Assignment VII		Problem 2
//****************************************************************************************

package edu.housatonic.www.assignment7.problem2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializeObject {
	
	private ObjectOutputStream output;
	
	// Open File Method
	public void openFile(String fileName){
		try{
			output = new ObjectOutputStream(new FileOutputStream(fileName));
		}
		catch(IOException e){
			System.err.println("Error opening file.");
		}
	}
	
	// Write to file method
	public void writeRecords(List<AccountRecord> records){
		openFile("records.ser");
		
		// Loop through each record and write it to the file
		for (AccountRecord record : records) {
			try{
				output.writeObject(record);
			}
			catch(IOException e){
				System.err.println("Error writing to file.");
			}
		}
		closeFile();
	}
	
	// Close file method
	public void closeFile(){
		if(output != null)
			try {
				output.close();
			} catch (IOException e) {
				System.err.println("Error closing file.");
				System.exit(1);
			}
	}
	
}
