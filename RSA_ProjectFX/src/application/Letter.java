/*
 *  This is the Letter class
 *  It's function is to assign a number to a letter
 *  eg. the letter A has the value of 100, the letter B has the value of 101
 *  ie. A = 101, B = 102, ..., Z = 125
 *  
 *  06/13/19
 *  
 *  Authors: Alexandre Castro and Samuel Gomez
 */
package application;

public class Letter {
	private char c;
	private int num;
	
	
	public Letter(char c, int num){
		this.c = c;
		this.num = num;
	}
	
	
	public char getCharacter(){
		return c;
	}
	
	public int getNum(){
		return num;
	}
	
	public String toString(){
		return c + " = " + num;
	}
	
}
