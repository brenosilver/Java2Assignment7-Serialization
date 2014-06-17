//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/23/14			Project 17.5
//
//	CSC*E224				Programming Assignment VII		Problem 1
//****************************************************************************************

package edu.housatonic.www.assignment7.problem1;

import java.io.IOException;

public class TestAccount {

	public static void main(String[] args) {
		FileMatch fm = new FileMatch();
		
		// Create Files
		//DataInput di = new DataInput();
		//di.addRecords();
		//di.addTransactions();
		
		try {
			fm.CompareRecords(fm.ReadOldMast(), fm.ReadTrans());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
