/*
 *  This is the Alphabet class
 *  It contains Letter objects inside an array list, forming a complete alphabet from A-Z
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
	}
	
	
	//*******methods for reading files******//
	public List<String> readLines(String filename)
	throws Exception
	{
		String line = null;
		List<String> records = new ArrayList();
		BufferedReader bf = new BufferedReader(new FileReader(filename));
		
		// reads line by line until we have an empty line
		while((line = bf.readLine()) != null){
			records.add(line); // adds each line to an array list
		}
		
		bf.close(); // close buffered reader
		//encrypt = new Encryption(records);
		
		return records;	
	}
	
	
	public void writeFile(String message)
	throws Exception
	{
		PrintWriter    pw = new PrintWriter("message.txt");
		pw.print(message);
		pw.close();
	}
	
	
	// print alphabet to the console
	public void printAlphabet(){
		System.out.print("{");
		for(Character i: alphaMap.keySet()){
			System.out.print("(" + i);
			System.out.print("," + alphaMap.get(i) + ")");
			System.out.print(",");
		}
		System.out.println("}");
	}
}
