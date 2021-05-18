package may18;

import java.io.File;
import java.util.Scanner;

//Exercise 3
public class FileDetailsWithName {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		File file = new File(fileName);
		System.out.println("Details for file :"+fileName);
		if(file.exists()) {
			System.out.println("Exists :"+file.exists());
			System.out.println("Readable :"+file.canRead());
			System.out.println("Writable :"+file.canWrite());
			System.out.println("File Size(Bytes) :"+file.length());
			if(fileName.split(".").length>1) {
				System.out.println("FileType :"+fileName.split(".")[1]);
			}else {
				System.out.println("FileType : Unknown");
			}
		}else {
			System.out.println("File " +fileName+ " Does not exist");
		}
	}
}
