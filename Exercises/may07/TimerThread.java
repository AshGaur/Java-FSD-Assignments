package may07;
import java.util.Scanner;
class TimerThread extends Thread{
	static String input;
	public static void main(String[] args) throws InterruptedException{
		Scanner sc = new Scanner(System.in);
		TimerThread timer = new TimerThread();
		System.out.println("Enter HH:MM:SS for which timer has to be set:");
		input = sc.nextLine();
		timer.start();
	}
	public void run(){
		try{
			startCalculations();
		}catch(InterruptedException e){
			System.out.println("Exception in sleep");
		}
	}
	static void startCalculations() throws InterruptedException{
		String temp[]= input.split(":");
		if(temp.length<3){
			System.out.println("Invalid timer input");
			return;
		}
		int hrs=0,mins=0,secs=0;
		try{
			hrs = Integer.parseInt(temp[0]);
			mins = Integer.parseInt(temp[1]);
			secs = Integer.parseInt(temp[2]);
		}catch(NumberFormatException e){
			System.out.println("Invalid timer input");
			return;
		}

		System.out.println("Timer Started:");

		while(hrs>0 || mins>0 || secs>0){
			if(secs<1){
				if(mins>0){
					mins--;
					secs = 59;
				}else if(hrs>0){
					hrs--;
					mins = 59;
					secs = 59;
				}
			}
			for(int i=secs;i>=0;i--){
				System.out.printf("\r%02d:%02d:%02d",hrs,mins,secs);
				Thread.sleep(1000);
				secs--;
			}	
		}
		System.out.println("\nTimer Ended");	
	}
}