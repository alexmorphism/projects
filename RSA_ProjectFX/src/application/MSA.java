/*
 * This is the MSA class
 * M = Mathematics
 * S = Sam
 * A = Alex
 * 
 * The purpose of this class is to combine two numbers together using the inject function
 * The inverse of the inject function "deject" returns a key object with the original numbers (n,d)
 * 
 *  * Authors: Alexandre Castro and Samuel Gomez
 */

package application;

import java.math.BigInteger;

public class MSA {

	
	/*
	 * Inject function takes two BigIntegers and creates one BigInteger
	 * 
	 */
	public BigInteger inject(BigInteger n, BigInteger d){
		BigInteger result = new BigInteger("0"); // creates a temporary BigInteger
		String nStr = n.toString();  // converts the current BigInteger to a string
		String dStr = d.toString();
		String s = "";
		int nLen = nStr.length(); // retrieves the length of the string (previous BigInteger)
		int dLen = dStr.length();
		
		int i = 0;
		
		// if the length of modulus n is greater than the length of d
		if(nLen > dLen){
			while(i < dLen){
				s += nStr.charAt(i); 
				s += dStr.charAt(i);
				i++;
			}
			while(i < nLen){
				s += nStr.charAt(i);
				s += 0 + "";
				i++;
			}
		} else {
			while(i < dLen){
				s += nStr.charAt(i);
				s += dStr.charAt(i);
				i++;
			}
		}
		
		result = new BigInteger(s);
		return result;
	}
	
	/*
	 * the deject function takes one BigInteger and returns a key such that has two BigIntegers
	 * the deject function is the inverse of the inject function.
	 */
	public Key deject(BigInteger a){
		Key aKey = new Key(BigInteger.ZERO, BigInteger.ZERO);
		String aStr = a.toString();
		int aLen = aStr.length();
		String n = "";
		String d = "";
		int dLen = 0;
		int i = 0;
		while(i < aLen){
			n += aStr.charAt(i);
			d += aStr.charAt(i+1);
			i += 2;
		}
		
		dLen = d.length();
		while(d.charAt(dLen-1) == '0'){
			d = d.substring(0, dLen-1);
			dLen -= 1;
		}
		
		aKey.setX(new BigInteger(n));
		aKey.setY(new BigInteger(d));
		return aKey;
	}
}
