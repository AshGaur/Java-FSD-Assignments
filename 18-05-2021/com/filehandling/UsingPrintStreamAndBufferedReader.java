package com.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class UsingPrintStreamAndBufferedReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PrintStream out = new PrintStream("myfile.txt");
			out.println("Writing this file with PrintWriter");
			out.println("Works Great !");
			out.flush();
			out.close();
			System.out.println("File Written !");
			System.out.println("----------------------------------");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Problem writing file:"+e.getMessage());
		}	//has a constructor that directly takes file name and creates file if it doesn't already exists
		
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(new File("myfile.txt")));
			String temp = "";
			StringBuilder data = new StringBuilder("");
			while((temp = bfr.readLine())!=null) {
				data.append(temp+"\n");
			}
			bfr.close();
			System.out.println("Data from file:");
			System.out.println(data);
		}catch(IOException e) {
			System.out.println("Problem reading file:"+e.getMessage());
		}
	}

}
