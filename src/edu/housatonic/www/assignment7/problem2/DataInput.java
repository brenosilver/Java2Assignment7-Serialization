//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/23/14			Project 17.7
//
//	CSC*E224				Programming Assignment VII		Problem 2
//****************************************************************************************

package edu.housatonic.www.assignment7.problem2;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DataInput {

	private Formatter output;
	
	
	public void openFile(String fileName){
		try{
			output = new Formatter(fileName);
		}
		catch(SecurityException e){
			System.err.println("You do not have write access to this file.");
			System.exit(1);
		}
		catch(FileNotFoundException e){
			System.err.println("Error opening or creating file.");
			System.exit(1);
		}
	}
	
	public void addRecords(){
		openFile("oldmast.txt");
		
		
		AccountRecord record = new AccountRecord();
		Scanner input = new Scanner(System.in);
		
		System.out.printf("%s\n%s\n%s\n%s\n\n", "To terminate input, type the end-of-file indicator ", "when you are prompted to enter input.", "On Unix/Linux/Mac OS X type <crtl> d then press Enter",
				"On Windows type <crtl> z then press Enter");
		
		System.out.printf("%s\n%s", "Enter account number (>0), first name, last name and balance.", "? ");
		
		while(input.hasNext()){
			try{
				record.setAccount(input.nextInt());
				record.setFirstName(input.next());
				record.setLastName(input.next());
				record.setBalance(input.nextDouble());
				
				if(record.getAccount() > 0){
					
					// write new record
					output.format("%d\t %s %s\t %.2f\n", record.getAccount(),
							record.getFirstName(), record.getLastName(), 
							record.getBalance());
				}
				else{
					System.out.println("ACcount number must be greater than 0.");
				}
			}
			catch(FormatterClosedException e){
				System.err.println("Error writing to file");
				return;
			}
			catch(NoSuchElementException e){
				System.err.println("Invalid input. Please try again.");
				input.nextLine(); // discard input so user can try again
			}
			
			System.out.printf("%s %s\n%s", "Enter account number (>0),", "first name, last name and balance,", "? ");
		}
		closeFile();
	}
	
	
	// Create transactions File
	public void addTransactions(){
		openFile("trans.txt");
		
		
		TransactionRecord record = new TransactionRecord();
		Scanner input = new Scanner(System.in);
		
		System.out.printf("%s\n%s\n%s\n%s\n\n", "To terminate input, type the end-of-file indicator ", "when you are prompted to enter input.", "On Unix/Linux/Mac OS X type <crtl> d then press Enter",
				"On Windows type <crtl> z then press Enter");
		
		System.out.printf("%s\n%s", "Enter account number (>0), and transaction ammount.", "? ");
		
		while(input.hasNext()){
			try{
				record.setAccNumber(input.nextInt());
				record.setTransAmmount(input.nextDouble());
				
				if(record.getAccNumber() > 0){
					
					// write new record
					output.format("%d\t %.2f\n", record.getAccNumber(),	record.getTransAmmount());
				}
				else{
					System.out.println("Account number must be greater than 0.");
				}
			}
			catch(FormatterClosedException e){
				System.err.println("Error writing to file");
				return;
			}
			catch(NoSuchElementException e){
				System.err.println("Invalid input. Please try again.");
				input.nextLine(); // discard input so user can try again
			}
			
			System.out.printf("%s %s\n%s", "Enter account number (>0),", " and transaction ammount,", "? ");
		}
		
		closeFile();
	}
	
	// Close File method
	public void closeFile(){
		if(output != null)
			output.close();
	}

}
