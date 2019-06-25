/*
 *  The tester class is used to test objects from other classes, their methods and their behaviors
 *  
 *  06/13/19
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
		KeyGenerator keyGen = new KeyGenerator(8, 1024);
		BigInteger x = new BigInteger("1234234567");
		BigInteger y = new BigInteger("56");
		BigInteger s = new BigInteger("0");
		
		Key testKey = new Key(BigInteger.ZERO, BigInteger.ZERO);
		
		
		
		
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
		//alpha.printAlphabet();
		//System.out.println(keyGen.toString());
		System.out.println("n = " + x.toString());
		System.out.println("d = " + y.toString());
		
		MSA msa = new MSA();
		s = msa.inject(x, y);
		
		System.out.println("inject = " + s.toString() + "\n");
		
		testKey = msa.deject(s);
		System.out.println("deject:\n" + testKey.toString());

	}

}
