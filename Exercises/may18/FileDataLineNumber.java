package may18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Exercise 1
public class FileDataLineNumber {
	public static void main(String[] args) {
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(new File("myfile.txt")));
			String temp = "";
			StringBuilder data = new StringBuilder("");
			int lineNumber = 1;
			while((temp = bfr.readLine())!=null) {
				data.append(String.format("%d. %s\n",lineNumber++,temp));
			}
			System.out.println("Data from file:");
			System.out.println(data);
		} catch (IOException e) {
			System.out.println("Problem reading file:"+e.getMessage());
		}
	}
}
