package may18;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CopyDataThread implements Runnable{
	FileReader reader;
	PrintWriter writer;
	@Override
	public void run() {
		char c[] = new char[300];
		//Reading operation
		try {
			int fileSize = reader.read(c);
			for(int i=1;i<=fileSize;i++) {
				writer.print(c[i-1]);
				writer.flush();
				if(i%10==0) {
					System.out.println("10 characters copied !");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println("Thread Sleep exception:"+e.getMessage());
					}
				}
			}
			writer.close();
			reader.close();
		}catch(IOException e) {
			System.out.println("Problem accessing file:"+e.getMessage());
		}
	}
}
