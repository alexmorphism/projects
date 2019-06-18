package application;

import java.math.BigInteger;
import java.util.Random;

public class KeyGenerator {
	
	private BigInteger p;
	private BigInteger q;
	private BigInteger n;
	private BigInteger d;
	private final BigInteger E = new BigInteger("65537");
	
	
	public KeyGenerator(){
		p = new BigInteger(256, 2, new Random());
		q = new BigInteger(256, 2, new Random());
		n = p.multiply(q);
		d = E.modInverse(p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
	}
	
	
	public String getP(){
		return p.toString();
	}
	
	public String getQ(){
		return q.toString();
	}
	
	public String getN(){
		return n.toString();
	}
	
	public String getD(){
		return d.toString();
	}
	
	
	public String toString(){
		return "p = " + p.toString() + "\nq = " + q.toString() + "\nn = " + n.toString() + 
				"\ne = " + E.toString() + "\nd = " + d.toString();
	}
	
}
