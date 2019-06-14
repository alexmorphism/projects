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

public class Alphabet {
	private ArrayList<Letter> alphaList;
	
	
	
	// no argument constructor constructs a new alphabet
	public Alphabet(){
		this.alphaList = new ArrayList<Letter>();
		initializeAlpha();
		//encrypt = new Encryption();
	}
	
	//initializes the alphabet  {(A,100), (B,101), ..., (Y,124), (Z,125)}
	private void initializeAlpha(){
		char c = 'A';
		int num = 100;
		
		for(int i = 0; i < 26; i++){
			alphaList.add(new Letter(c , num));
			c++;
			num++;
		}
		alphaList.add(new Letter(' ', num++));
		alphaList.add(new Letter('?', num++));
		alphaList.add(new Letter('!', num++));
		
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
		//String line = null;
		//BufferedReader bf = new BufferedReader(new FileReader(message));
		PrintWriter    pw = new PrintWriter("message.txt");
		
//		while((line = bf.readLine()) != null){
//			pw.println(line);
//		}
		
		pw.print(message);
		pw.close();
	}
	
	
	// print alphabet to the console
	public void printAlphabet(){
		System.out.print("{");
		for(Letter i: alphaList){
			System.out.print(i);
			System.out.print(",");
		}
		System.out.println("}");
	}
	
	
}
