package com.filehandling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {

	public static void main(String[] args) {
		File file = new File("myfile.txt");
		
		//Writing to file
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("Welcome to file created !\nUsing FileWriter to write in files\n123456");
			fw.flush();	//important to flush and close as it cleans buffer and completes all pending write operation with this file
			fw.close();	//if flush and close are not given sometimes the file may not get written
			System.out.println("File Successfully Written");
		} catch (IOException e) {
			System.out.println("Unable to create file !");
		}
		
		char filechars[] = new char[200];
		//Reading file
		try {
			FileReader fr = new FileReader(file);
			int fileSize = fr.read(filechars);
			System.out.println("File Size:"+fileSize+" has contents:");
			int count = 0;
			for(char c:filechars) {
				System.out.print(c);
				count++;
			}
			System.out.println("File reading complete !");
			System.out.println("count="+count);
			System.out.println("filesize="+fileSize);
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
