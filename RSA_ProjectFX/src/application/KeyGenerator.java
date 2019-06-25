/*
 *  This is the KeyGenerator class
 *  The purpose of this class is to generate a public and a private key pair
 *  
 *  06/21/19
 *  Authors: Alexandre Castro and Samuel Gomez
 */
package application;

import java.math.BigInteger;
import java.util.Random;

public class KeyGenerator {
	
	private BigInteger p;
	private BigInteger q;
	private BigInteger n;
	private BigInteger d;
	private final BigInteger E = new BigInteger("65537");
	private FileIO reader;
	
	
	public KeyGenerator(int bits, int prob){
		reader = new FileIO();
		p = new BigInteger(bits, prob, new Random());
		q = new BigInteger(bits, prob, new Random());
		if(!isPrime(p))
			p = p.nextProbablePrime(); //returns the next Big Integer that is probably prime
		if(!isPrime(q))
			q = q.nextProbablePrime(); //returns the next Big Integer that is probably prime
		n = p.multiply(q);
		d = E.modInverse(p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE))); // d = e^-1 mod (p-1)(q-1)
		//createPublicPair();
		//createPrivatePair();
	}
	
	
	public BigInteger getP(){
		return p;
	}
	
	public BigInteger getQ(){
		return q;
	}
	
	public BigInteger getN(){
		return n;
	}
	
	public BigInteger getD(){
		return d;
	}
	
	//creates a public key and writes to a file
	private void createPublicPair(){
		String puPair = orderedPair(n, E);
		try{
			reader.writeToFile("public_key.txt", puPair);
		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
	//creates a private key and writes to a file.
	private void createPrivatePair(){
		String prPair = orderedPair(n, d);
		try{
			reader.writeToFile("private_key.txt", prPair);
		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	//creates an ordered pair x y such that x,y is a BigInteger
	private String orderedPair(BigInteger x, BigInteger y){
		String pair = x.toString() + " " + y.toString();
		return pair;
	}
	
	//check if current BigInteger is prime, if not generate the next prime BigInteger
	public boolean isPrime(BigInteger b){
		if(b.isProbablePrime(1024))
			return true;
		
		return false;
	}
	
	//returns a formatted string
	@Override 
	public String toString(){
		return "p = " + p.toString() + "\nq = " + q.toString() + "\nn = " + n.toString() + 
				"\ne = " + E.toString() + "\nd = " + d.toString();
	}
	
}
