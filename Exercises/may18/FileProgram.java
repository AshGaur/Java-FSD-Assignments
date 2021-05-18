package may18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class FileProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File sourceFile = new File("source.txt");
			if (!sourceFile.exists()) {
				PrintWriter pw = new PrintWriter("source.txt");
				pw.println("Lorem Ipsum is simply dummy text"
						+ " of the printing and typesetting industry. "
						+ "Lorem Ipsum has been the industry's standard dummy "
						+ "text ever since the 1500s, when an unknown printer "
						+ "took a galley of type and scrambled it to make a type"
						+ " specimen book. It has survived not only five centuries");
				pw.flush();
				pw.close();
			}
			FileReader fileReader = new FileReader(new File("source.txt"));
			PrintWriter out = new PrintWriter("target.txt");
			//Thread start
			new Thread(new CopyDataThread(fileReader,out)).start();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
