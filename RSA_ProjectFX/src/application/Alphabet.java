/*
 *  This is the Alphabet class
 *  It contains letters and numbers implemented on a hash map data structure
 *  Where the key is a Character and the value is an Integer
 *  
 *  
 *  06/13/19
 *  
 *  Authors: Alexandre Castro and Samuel Gomez
 */
package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Alphabet {
	private HashMap<Character, Integer> alphaMap;
	
	
	// no argument constructor constructs a new alphabet
	public Alphabet(){
		alphaMap = new HashMap<Character, Integer>();
		initializeAlpha();
	}
	
	//initializes the alphabet  {(A,100), (B,101), ..., (Y,124), (Z,125)}
	private void initializeAlpha(){
		char c = 'a';
		int num = 100;
		for(int i = 0; i < 52; i++){
			alphaMap.put(c, num);
			c++;
			if(i == 25)
				c = 'A';
			num++;
		}
		alphaMap.put(' ', num++);
		alphaMap.put('?', num++);
		alphaMap.put('!', num++);
		alphaMap.put('.', num++);
	}
	
	
	// print alphabet to the console
	public void printAlphabet(){
		int j = 0;
		System.out.print("{");
		for(Character i: alphaMap.keySet()){
			System.out.print("(" + i);
			System.out.print("," + alphaMap.get(i) + ")");
			System.out.print(",");
			j++;
			if(j % 10 == 0)
				System.out.println();
		}
		System.out.println("}");
	}
}
