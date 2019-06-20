package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
	
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
		
		return records;	
	}
	
	//reads a file and return a list containing the keys
	public List<String> readKey(File selectedFile)
	throws Exception
	{
		String word = null;
		List<String> records = new ArrayList();
		Scanner scan = new Scanner(new FileReader(selectedFile));
		
		while(scan.hasNext()){
			word = scan.next();
			
			if(!word.equals("(") || !word.equals(",") || !word.equals(")") ){
				records.add(word);
			}
		}
		return records;
	}
	
	public void writeToFile(String filename, String message)
	throws Exception
	{
		PrintWriter pw = new PrintWriter(filename);
		pw.print(message);
		pw.close();
	}
}
