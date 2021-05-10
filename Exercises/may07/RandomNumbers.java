package may07;
import java.util.Date;
class RandomNumbers{
	public static void main(String[] args) throws InterruptedException{
		//Printing 5 random numbers between 1000 and 9999
		for(int i=0;i<5;i++){
			int num = new java.util.Date().hashCode()%10000;
			System.out.println(num>1000?num:num+1000);
			Thread.sleep(500);
		}
	}
}