import java.util.Date;
import java.text.SimpleDateFormat;
class LiveChat extends Thread{
	public static void main(String[] args) {
		LiveChat person1 = new LiveChat();
		LiveChat person2 = new LiveChat();
		LiveChat person3 = new LiveChat();

		person1.setName("Ashutosh");
		person2.setName("Aman");
		person3.setName("Arun");

		person1.start();
		person2.start();
		person3.start();
	}
	@Override
	public void run(){
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		for(int i=0;i<5;i++){
			System.out.printf("%-10s %10s : %s\n",
				Thread.currentThread().getName(),
				formatter.format(new Date()),
				MessageContent.messages[(int)(Math.random()*10)]
				);	
		}
	}
}

class MessageContent{
	static String[] messages= new String[]{
		"Hello","Great","Nice Job","Amazing","Ridiculous",
		"Whats happening ?","What was that ?","I didn't understand","Lets Rock","Its break"
	};
}