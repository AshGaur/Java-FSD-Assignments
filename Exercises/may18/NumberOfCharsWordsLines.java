package may18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Exercise 2
public class NumberOfCharsWordsLines {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(new File("myfile.txt")));
			String temp = "";
			StringBuilder data = new StringBuilder("");
			int lineNumber = 1;
			int words = 0;
			int numOfChars = 0;
			while((temp = bfr.readLine())!=null) {
				words+=temp.split(" ").length;
				numOfChars+=temp.toCharArray().length;
				data.append(String.format("%d. %s\n",lineNumber++,temp));
			}
			System.out.println("Data from file:");
			System.out.println(data);
			System.out.println("---------------------------");
			System.out.println("This file contains:");
			System.out.println("Characters = "+numOfChars);
			System.out.println("Words = "+words);
			System.out.println("Lines = "+(lineNumber-1));
		} catch (IOException e) {
			System.out.println("Problem reading file:"+e.getMessage());
		}
	}
}
