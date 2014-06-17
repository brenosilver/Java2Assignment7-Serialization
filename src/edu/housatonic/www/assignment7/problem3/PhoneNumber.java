//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/23/14			Project 17.8
//
//	CSC*E224				Programming Assignment VII		Problem 3
//****************************************************************************************

package edu.housatonic.www.assignment7.problem3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PhoneNumber {
	private static long number;
	private static String[] lettersArray = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY"};
	private static String matches; // All results from match()
	
	// Constructor
	public PhoneNumber() {
		matches = "";
	}
	
	// Main method
	public static void main(String[] args){
		
		// get phone number from console
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 7 digit phone number");
		
		number = input.nextLong();
		System.out.println(number);

		input.close();
		
		PhoneNumber pn = new PhoneNumber();
		pn.convertToString();
	}
	
	// Convert phone Number into a String
	public void convertToString(){
		String phoneNumber = String.valueOf(number);
		match(phoneNumber, "");
	}
	
	// Match method
	public void match(String phoneNumber, String convLetter){
		
		 // get the position of the letter from the phone number
		int pos = Integer.parseInt(phoneNumber.substring(0,1));
		String letters = lettersArray[pos];
		
		// take out the current number from the phone number
		String remainingNumber = phoneNumber.substring(1);
		
		for(int i = 0; i <letters.length(); i++){
			
			char letter = letters.charAt(i);
			String result = convLetter + letter;
			
			// if the remaining sting is < than 0 then match is completed
			if(remainingNumber.length() < 1){
				System.out.println("result: " + result);
				matches += result + "\n";
			}
			else
				match(remainingNumber, result);
		}
		
		writeToFile(matches);
	}

	
	// Create File
	public void writeToFile(String result){
		
		PrintStream pt = null;
		try {
			pt = new PrintStream(new FileOutputStream("phone.txt", false));
			
			pt.format("%s\n", result);
		} catch (FileNotFoundException e) {
			System.err.println("File was not found or could not be created");
		}
		finally{
			if(pt != null)
				pt.close();
		}
		
	}

}