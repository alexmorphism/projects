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
		
		String message = "file1";
		
		BigInteger p = new BigInteger(100, 2, new Random());
		BigInteger q = new BigInteger(100, 2, new Random());
		
		BigInteger n = p.multiply(q);
		
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
		System.out.println("p = " + p);
		System.out.println("q = " + q);
		System.out.println("n = " + n.toString());

	}

}
