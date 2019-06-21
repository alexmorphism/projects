/*
 *  This FileIO class -> File in and out
 *  The purpose of this class is to provide methods for reading and writing files
 *  
 *  06/21/19
 *  Authors: Alexandre Castro and Samuel Gomez
 */
package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
	
	// read lines from a file using a BufferedReader and store into an ArrayList
	// each line is stored in an index of the ArrayList, growing as necessary
	public List<String> readLines(String filename)
	throws Exception
	{
		String line = null;
		List<String> records = new ArrayList<String>();
		BufferedReader bf = new BufferedReader(new FileReader(filename));
		
		// reads line by line until it reaches an empty line
		while((line = bf.readLine()) != null){
			records.add(line); // adds each line to an array list
		}
		bf.close(); // close buffered reader
		return records;	
	}
	
	//reads a file and return a list containing a key
	public List<String> readKey(File selectedFile)
	throws Exception
	{
		String word = null;
		List<String> records = new ArrayList<String>();
		Scanner scan = new Scanner(new FileReader(selectedFile));
		
		while(scan.hasNext()){
			word = scan.next();
			records.add(word);
		}
		return records;
	}
	
	// method writes a message to a file given the filename
	public void writeToFile(String filename, String message)
	throws Exception
	{
		PrintWriter pw = new PrintWriter(filename);
		pw.print(message);
		pw.close();
	}
}
