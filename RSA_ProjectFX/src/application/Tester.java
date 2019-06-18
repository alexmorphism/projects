/*
 *  This is a tester class to test methods and their behaviors
 *  06/13/19
 *  
 *  Authors: Alexandre Castro and Samuel Gomez
 */
package application;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tester {

	public static void main(String[] args) throws Exception {
		Alphabet alpha = new Alphabet();
		KeyGenerator keyGen = new KeyGenerator();
		
		String message = "file1";
		
		/*
		try{
			for(String s: alpha.readLines(message)){
				System.out.println(s);
			}
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		//alpha.printAlphabet();
		 */

		System.out.println(keyGen.toString());

	}

}
