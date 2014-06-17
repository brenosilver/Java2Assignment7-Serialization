//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/23/14			Project 17.7
//
//	CSC*E224				Programming Assignment VII		Problem 2
//****************************************************************************************

package edu.housatonic.www.assignment7.problem2;

import java.io.IOException;
import java.util.BitSet;

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
		
		// Serialize records
		SerializeObject ser = new SerializeObject();
		if(!fm.getRecords().isEmpty())
			ser.writeRecords(fm.getRecords());
		
		// Deserialize records
		DeserializeObj des = new DeserializeObj();
		des.readRecords();
		

	}

}
