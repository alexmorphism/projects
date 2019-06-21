/*
 *  This is the Key class
 *  The purpose of this class is to hold information for a specific key, private or public
 *  A key object contains two Big Integers
 *  The key class provide getters, setters as well as a toString
 *  
 *  06/21/19
 *  Authors: Alexandre Castro and Samuel Gomez
 */
package application;

import java.math.BigInteger;

public class Key {
	private BigInteger x;
	private BigInteger y;
	
	public Key(BigInteger x, BigInteger y){
		this.x = x;
		this.y = y;
	}
	
	public BigInteger getX(){
		return x;
	}
	
	public BigInteger getY(){
		return y;
	}
	
	public void setX(BigInteger otherX){
		this.x = otherX;
	}
	
	public void setY(BigInteger otherY){
		this.y = otherY;
	}
	
	public String toString(){
		return x + "\n" + y;
	}
}
